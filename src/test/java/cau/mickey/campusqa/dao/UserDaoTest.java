package cau.mickey.campusqa.dao;

import cau.mickey.campusqa.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void addUser() {
        User user = new User();
        user.setId(1000);
        user.setStatus(0);
        user.setEmail("test233@163.com");
        user.setName("李明");
        user.setHeadUrl("http:www.xxx.jpg");
        user.setPassword("123qwe.");
        user.setSalt("qwert");
        Assert.assertTrue(userDao.addUser(user)>0);
    }

    @Test
    public void selectById() {
        int id = 40;
        User user = userDao.selectById(id);
        Assert.assertNotNull(user);
        System.out.println("用户名："+user.getName());
    }

    @Test
    public void selectByName() {
    }

    @Test
    public void selectByEmail() {
    }

    @Test
    public void updatePassword() {
    }

    @Test
    public void updateStatus() {
    }

    @Test
    public void deleteById() {
        int id = 48;
        userDao.deleteById(id);
        Assert.assertNull(userDao.selectById(id));
    }
}