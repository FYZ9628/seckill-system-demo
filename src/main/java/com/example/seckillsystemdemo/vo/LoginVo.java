package com.example.seckillsystemdemo.vo;

import com.example.seckillsystemdemo.annotations.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 登录参数
 *
 * @Author Administrator
 * @Date 2022/7/12 17:41
 */
@Data
public class LoginVo {

    @NotNull
    @IsMobile
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;

}
