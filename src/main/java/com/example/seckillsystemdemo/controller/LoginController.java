package com.example.seckillsystemdemo.controller;

import com.example.seckillsystemdemo.service.IUserService;
import com.example.seckillsystemdemo.vo.LoginVo;
import com.example.seckillsystemdemo.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 登录控制器
 *
 * 要实现页面跳转不能用 @RestController， 只能用 @Controller
 * 因为 @RestController 默认会给这个类下所有的方法加上 @ResponseBody 注解，
 * @ResponseBody 这个注解的意思是返回一个对象
 *
 * @Author Administrator
 * @Date 2022/7/12 17:00
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;

    /**
     * 跳转登录界面
     * localhost:8080/login/toLogin
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录功能
     *
     * @param loginVo
     * @return
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        return userService.doLogin(loginVo, request, response);
    }
}
