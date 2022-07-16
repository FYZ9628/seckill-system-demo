package com.example.seckillsystemdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckillsystemdemo.entity.Goods;
import com.example.seckillsystemdemo.vo.GoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author fengyuzhen
 * @since 2022-07-13
 */
@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取商品列表
     *
     * @return
     */
    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     *
     * @return
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
