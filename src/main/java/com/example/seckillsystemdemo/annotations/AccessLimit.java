package com.example.seckillsystemdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 访问限流（哪个接口需要做流量限制的就在哪个方法上加这个注解即可）
 *
 * @Author Administrator
 * @Date 2022/7/15 16:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {

    /**
     * 设置要计算在 N 秒内的访问量
     *
     * @return
     */
    int second();

    /**
     * 设置在 N 秒可以访问的最大次数
     * @return
     */
    int maxCount();

    /**
     * 是否需要验证登录状态
     *
     * @return
     */
    boolean needLogin() default true;
}
