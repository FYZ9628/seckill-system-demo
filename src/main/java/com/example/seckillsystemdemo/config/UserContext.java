package com.example.seckillsystemdemo.config;

import com.example.seckillsystemdemo.entity.User;

/**
 * 线程上下文中的用户信息
 *
 * @Author Administrator
 * @Date 2022/7/15 16:37
 */
public class UserContext {

    private static ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        userThreadLocal.set(user);
    }

    public static User getUser() {
        return userThreadLocal.get();
    }
}
