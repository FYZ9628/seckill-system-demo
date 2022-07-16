package com.example.seckillsystemdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckillsystemdemo.entity.User;
import com.example.seckillsystemdemo.vo.LoginVo;
import com.example.seckillsystemdemo.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-12
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     * @param loginVo
     * @param request
     * @param response
     * @return
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据用户 cookie 获取用户
     *
     * @param userTicket
     * @return
     */
    User getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response);

    /**
     * 更新密码
     *
     * @param userTicket
     * @param password
     * @param request
     * @param response
     * @return
     */
    RespBean updatePassword(String userTicket, String password, HttpServletRequest request, HttpServletResponse response);
}
