package com.example.seckillsystemdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckillsystemdemo.entity.Goods;
import com.example.seckillsystemdemo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * 获取商品列表
     *
     * @return
     */
    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     *
     * @param goodsId
     * @return
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
