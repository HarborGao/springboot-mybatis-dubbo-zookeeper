package com.harbor.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.harbor.common.domain.Goods;
import com.harbor.common.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author harborGao
 * @create 2020/11/17
 */

@Controller
public class GoodsController {

    @Resource
    @Reference(version = "1.0.0")
    private GoodsService goodsService;

    @RequestMapping("getAllGoods")
    @ResponseBody
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }
}
