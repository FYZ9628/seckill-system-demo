package com.example.seckillsystemdemo.exception;

import com.example.seckillsystemdemo.constants.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全局异常
 *
 * @Author Administrator
 * @Date 2022/7/12 19:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;
}
