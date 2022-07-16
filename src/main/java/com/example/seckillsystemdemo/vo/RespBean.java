package com.example.seckillsystemdemo.vo;

import com.example.seckillsystemdemo.constants.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @Author Administrator
 * @Date 2022/7/12 17:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * 成功一般都是固定返回，所以不需要入参，但是失败各有各的返回码，所以需要入参
     *
     * @return
     */
    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     * 成功一般都是固定返回，所以不需要入参，但是失败各有各的返回码，所以需要入参
     *
     * @return
     */
    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(), RespBeanEnum.SUCCESS.getMessage(), obj);
    }


    /**
     * 失败返回结果
     * 成功一般都是固定返回，所以不需要入参，但是失败各有各的返回码，所以需要入参
     *
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    /**
     * 失败返回结果
     * 成功一般都是固定返回，所以不需要入参，但是失败各有各的返回码，所以需要入参
     *
     * @return
     */
    public static RespBean error(RespBeanEnum respBeanEnum, Object obj) {
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), obj);
    }
}
