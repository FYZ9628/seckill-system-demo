package com.example.seckillsystemdemo.validator;

import com.example.seckillsystemdemo.annotations.IsMobile;
import com.example.seckillsystemdemo.utils.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号码校验规则
 *
 * @Author Administrator
 * @Date 2022/7/12 18:34
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    /**
     * 初始化
     * @param constraintAnnotation
     */
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    /**
     * 进行校验
     * @param value
     * @param Context
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext Context) {
        if (required) {
            return ValidatorUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
