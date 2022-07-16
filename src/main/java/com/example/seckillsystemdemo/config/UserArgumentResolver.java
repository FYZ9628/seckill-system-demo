package com.example.seckillsystemdemo.config;

import com.example.seckillsystemdemo.entity.User;
import com.example.seckillsystemdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 自定义用户参数
 * 解决用户在不同页面之间跳转每次都查询登录用户的信息，这里做了统一处理
 *
 * @Author Administrator
 * @Date 2022/7/13 11:26
 */
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private IUserService userService;

    /**
     * 若返回false，则不执行方法 resolveArgument()
     * 若返回true，则执行方法 resolveArgument()
     *
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == User.class;
    }

    /**
     * 这里拦截是在进入Controller之前，而这里处理的参数会直接作为入参传给Controller的方法
     *
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //返回 user 对象给 Controller的各个方法
        return UserContext.getUser();
    }
}
