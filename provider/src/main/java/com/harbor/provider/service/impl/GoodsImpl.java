package com.harbor.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.harbor.common.domain.Goods;
import com.harbor.common.service.GoodsService;
import com.harbor.provider.mapper.GoodsMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author harborGao
 * @create 2020/11/17
 */
@Service(version = "1.0.0")
public class GoodsImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        return goodsMapper.getGoodsByName(name);
    }
}
