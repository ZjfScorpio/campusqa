package cau.mickey.campusqa.controller;

import cau.mickey.campusqa.model.Question;
import cau.mickey.campusqa.model.User;
import cau.mickey.campusqa.service.CommentService;
import cau.mickey.campusqa.service.FollowService;
import cau.mickey.campusqa.service.QuestionService;
import cau.mickey.campusqa.service.UserService;
import cau.mickey.campusqa.util.CampusQaUtil;
import cau.mickey.campusqa.util.EnvContext;
import cau.mickey.campusqa.util.PageBean;
import cau.mickey.campusqa.vo.ViewObject;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    private static int flag = 1;
    @Autowired
    private UserService userService;
    @Autowired
    private QuestionService qeustionService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FollowService followService;

    @Autowired
    private EnvContext envContext;

    @RequestMapping(method = {RequestMethod.GET})
    public String admin(Model model) {
        if(envContext.getUser()!=null){
            String userName = envContext.getUser().getName();
            if (userName.equals("admin")) {
                return "/admin/index";
            }
        }
        return "/admin/login";
    }


    @RequestMapping(path = {"/login"}, method = {RequestMethod.POST})
    public String login(Model model,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "next", required = false) String next,
                        @RequestParam(value = "rememberMe", defaultValue = "false") boolean rememberMe,
                        HttpServletResponse response) {
        try {
            Map<String, String> map = userService.login(username, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket"));
                cookie.setPath("/");
                if(rememberMe){
                    cookie.setMaxAge(Integer.MAX_VALUE);
                }
                response.addCookie(cookie);
                if(!StringUtils.isEmpty(next)){
                    return "redirect:"+next;
                }
                if(!username.equals("admin")){
                    map.put("msg","非管理员用户");
                    model.addAttribute("msg", map.get("msg"));
                    return "/admin/login";
                }
                return "redirect:/admin";
            } else {
                model.addAttribute("msg", map.get("msg"));
                return "/admin/login";
            }
        } catch (Exception e) {
            logger.error("登录出现异常. " + e.getMessage());
            return "/admin/login";
        }
    }

    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET})
    public String logout(@CookieValue("ticket")String ticket) {
        userService.logout(ticket);
        return "redirect:/admin";
    }

    @RequestMapping(path = {"/users"}, method = {RequestMethod.GET})
    public String getUsers(Model model) {
        return "/admin/user/list";
    }

    @ResponseBody
    @RequestMapping(value = "/users_page")
    public PageBean<User> queryForUsersPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                       @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                       @RequestParam(value = "date", required = false) String date,
                                       @RequestParam(value = "search", required = false) String search,
                                       HttpServletRequest request) {
        Map<String,String[]> params = request.getParameterMap();
        List<User> users = userService.getUsers();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return new PageBean<User>(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/user_silence", method = {RequestMethod.POST})
    public String userSilence(@RequestParam(value = "id") int id,
                                       HttpServletRequest request) {
        User user = userService.getUser(id);
        if(user.getStatus()==0)
            user.setStatus(1);
        else
            user.setStatus(0);
        userService.updateStatus(user);
        return CampusQaUtil.getJSONString(0);
    }

    @ResponseBody
    @RequestMapping(value = "/user_del", method = {RequestMethod.POST})
    public String userDel(@RequestParam(value = "id") int id,
                               HttpServletRequest request) {
        userService.deleteById(id);
        return CampusQaUtil.getJSONString(0);
    }



    @RequestMapping(path = {"/questions"}, method = {RequestMethod.GET})
    public String getQuestions(Model model) {
        List<Question> questions = qeustionService.getLatestQuestion(0,0,2000);
        model.addAttribute("questions", questions);
        return "/admin/question/list";
    }

    @ResponseBody
    @RequestMapping(value = "/questions_page")
    public PageBean<Question> queryForQuestionsPage(@RequestParam(value = "start", defaultValue = "1") int start,
                                       @RequestParam(value = "length", defaultValue = "10") int pageSize,
                                       @RequestParam(value = "date", required = false) String date,
                                       @RequestParam(value = "search", required = false) String search,
                                       HttpServletRequest request) {
        List<Question> questions = qeustionService.getLatestQuestion(0,0,2000);
        PageInfo<Question> pageInfo = new PageInfo<>(questions);
        return new PageBean<>(pageInfo);
    }

    @ResponseBody
    @RequestMapping(value = "/question_del", method = {RequestMethod.POST})
    public String questionDel(@RequestParam(value = "id") int id,
                          HttpServletRequest request) {
        qeustionService.delQuestionById(id);
        return CampusQaUtil.getJSONString(0);
    }

}
