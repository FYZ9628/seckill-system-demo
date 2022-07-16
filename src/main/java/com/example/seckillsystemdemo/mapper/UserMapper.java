package com.example.seckillsystemdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckillsystemdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-12
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

}
