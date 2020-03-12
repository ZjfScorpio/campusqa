package cau.mickey.campusqa.service;

import cau.mickey.campusqa.async.EventModel;
import cau.mickey.campusqa.async.EventProducer;
import cau.mickey.campusqa.async.EventType;
import cau.mickey.campusqa.dao.LoginTicketDao;
import cau.mickey.campusqa.dao.UserDao;
import cau.mickey.campusqa.model.Comment;
import cau.mickey.campusqa.model.LoginTicket;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.service.Redis.RedisAdapter;
import cau.mickey.campusqa.util.CampusQaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
/**
 * @author mickey
 * 用户相关
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginTicketDao loginTicketDao;

    @Autowired
    private RedisAdapter redisAdapter;

    @Autowired
    private EventProducer eventProducer;

    public List<User> getUsers() {
        return userDao.selectUsers();
    }

    public User getUser(int id) {
        return userDao.selectById(id);
    }

    public User getUserByName(String name){
        return userDao.selectByName(name);
    }

    public void updateStatus(User user){
        userDao.updateStatus(user);
    }

    public void deleteById(int id){
         userDao.deleteById(id);
    }


    public Map<String, String> login(String username, String password) {
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空！");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空！");
            return map;
        }
        User user = userDao.selectByName(username);
        if (user == null) {
            map.put("msg", "用户名不存在！");
            return map;
        }
        if (!CampusQaUtil.MD5(password + user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确！");
            return map;
        }
        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    public String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        Date now = new Date();
        now.setTime(3600 * 24 * 15 * 1000 + now.getTime());
        ticket.setUserId(userId);
        ticket.setExpired(now);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDao.addTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String ticket) {
        loginTicketDao.updateStatus(ticket, 1);
    }

    public Map<String, String> register(String username, String password, String email) {
        Map<String, String> map = new HashMap<>();

//        if(redisAdapter.sismember("email", email)){
//            map.put("msg","该邮箱已经申请注册了，请到邮箱内激活完成注册！");
//            return map;
//        }

        if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空！");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空！");
            return map;
        }
        if (StringUtils.isEmpty(password)) {
            map.put("msg", "邮箱不能为空！");
            return map;
        }
        User user = userDao.selectByName(username);
        if (user != null) {
            map.put("msg", "用户名已经被注册！");
            return map;
        }
        user= userDao.selectByEmail(email);
        if (user != null) {
            map.put("msg", "该邮箱已经被注册！");
            return map;
        }

        //userDao.addUser(user);
        String register_ticket= CampusQaUtil.MD5(email);
        redisAdapter.hset(register_ticket,"email",email);
        redisAdapter.hset(register_ticket,"username",username);
        redisAdapter.hset(register_ticket,"password", password);
        redisAdapter.expire(register_ticket,60*15);
        redisAdapter.sadd("email",email);

        eventProducer.fireEvent(new EventModel(EventType.REGISTER)
        .setExt("register_ticket",register_ticket)
        .setExt("email",email));
        map.put("toVerify","待邮件验证");

        return map;
    }

    public boolean emailVerify(String p){
        Random random = new Random();
        if(redisAdapter.exists(p)){
            try {
                String email=redisAdapter.hget(p,"email");
                String username=redisAdapter.hget(p,"username");
                String password=redisAdapter.hget(p,"password");
                User user = new User();
                user.setName(username);
                user.setEmail(email);
                user.setSalt(UUID.randomUUID().toString().substring(0, 5));
                //user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
                user.setHeadUrl(String.format("/images/head/head%d.jpg", random.nextInt(21)));
                user.setPassword(CampusQaUtil.MD5(password + user.getSalt()));
                userDao.addUser(user);
                redisAdapter.del(p);
                redisAdapter.srem("email",email);
                return true;
            } catch (Exception e){
                logger.error("注册失败"+e.getMessage());
                return false;
            }
        }
        return false;
    }
}
