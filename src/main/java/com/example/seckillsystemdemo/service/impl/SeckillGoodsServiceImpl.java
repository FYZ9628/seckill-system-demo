package com.example.seckillsystemdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckillsystemdemo.entity.SeckillGoods;
import com.example.seckillsystemdemo.mapper.SeckillGoodsMapper;
import com.example.seckillsystemdemo.service.ISeckillGoodsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀商品表 服务实现类
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
@Service
public class SeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements ISeckillGoodsService {

}
