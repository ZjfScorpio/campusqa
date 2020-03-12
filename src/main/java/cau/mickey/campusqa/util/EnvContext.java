package cau.mickey.campusqa.util;

import cau.mickey.campusqa.model.User;
import org.springframework.stereotype.Component;

/**
 * @author mickey
 * 用 ThreadLocal 去单独存储每一个线程携带的 user 信息
 * 用 ThreadLocal 去单独存储每一个线程携带的 question 信息
 */
@Component
public class EnvContext {
    private static ThreadLocal<User> users = new ThreadLocal<User>();


    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();
    }
}
