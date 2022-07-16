package com.example.seckillsystemdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试
 *
 * @Author Administrator
 * @Date 2022/7/12 15:20
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    /**
     * 测试页面跳转
     *
     * @param model
     * @return
     */
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "xxx");
        return "hello";
    }
}
