package com.harbor.common.service;

import com.harbor.common.domain.Goods;

import java.util.List;

/**
 * @author harborGao
 * @create 2020/11/17
 */
public interface GoodsService {
    List<Goods> getAllGoods();
    List<Goods> getGoodsByName(String name);
}
