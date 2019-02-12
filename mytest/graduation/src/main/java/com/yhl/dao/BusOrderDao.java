package com.yhl.dao;

import com.yhl.domain.OrderSeeingbus;
import com.yhl.domain.OrderTicket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusOrderDao {

    @Select("select * from tab_order_seeingbus where uid=#{uid} limit #{start},#{end}")
    public List<OrderSeeingbus> getBusOrderByUid(@Param("uid") Integer uid,
                                                 @Param("start") Integer start, @Param("end")Integer end);



    @Select("select count(*) from tab_order_seeingbus")
    public  Integer getBusCountByUid(@Param("uid") Integer uid);
}
