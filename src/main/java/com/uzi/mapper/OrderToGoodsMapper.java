package com.uzi.mapper;

import com.uzi.model.OrderToGoods;
import com.uzi.model.OrderToGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderToGoodsMapper {
    int countByExample(OrderToGoodsExample example);

    int deleteByExample(OrderToGoodsExample example);

    int deleteByPrimaryKey(Integer otgid);

    int insert(OrderToGoods record);

    int insertSelective(OrderToGoods record);

    List<OrderToGoods> selectByExample(OrderToGoodsExample example);

    OrderToGoods selectByPrimaryKey(Integer otgid);

    int updateByExampleSelective(@Param("record") OrderToGoods record, @Param("example") OrderToGoodsExample example);

    int updateByExample(@Param("record") OrderToGoods record, @Param("example") OrderToGoodsExample example);

    int updateByPrimaryKeySelective(OrderToGoods record);

    int updateByPrimaryKey(OrderToGoods record);
}