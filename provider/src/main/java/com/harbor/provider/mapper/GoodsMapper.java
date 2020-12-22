package com.harbor.provider.mapper;

import com.harbor.common.domain.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author harborGao
 * @create 2020/11/17
 */
@Mapper
public interface GoodsMapper {

    @Results(id = "goodsMap", value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "price", property = "price"),
            @Result(column = "stock", property = "stock"),
            @Result(column = "goodsTypeId", property = "goodsTypeId")})
    @Select("SELECT id,name,price,stock,goodsTypeId FROM goods")
    List<Goods> getAllGoods();

    @Select("SELECT id,name,price,stock,goodsTypeId FROM goods where name = #{name}")
    @ResultMap("goodsMap")
    List<Goods> getGoodsByName(String name);
}
