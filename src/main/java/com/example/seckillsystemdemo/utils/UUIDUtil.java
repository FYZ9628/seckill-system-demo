package com.example.seckillsystemdemo.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @Author Administrator
 * @Date 2022/7/12 19:29
 */
public class UUIDUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
