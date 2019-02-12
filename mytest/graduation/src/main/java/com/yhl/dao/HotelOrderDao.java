package com.yhl.dao;

import com.yhl.domain.OrderHotel;
import com.yhl.domain.OrderTicket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface HotelOrderDao {

    @Select("select * from tab_order_hotel where uid=#{uid} limit #{start},#{end}")
    public List<OrderHotel> getTicketOrderByUid(@Param("uid") Integer uid,
                                                 @Param("start") Integer start, @Param("end")Integer end);

    @Select("select count(*) from tab_order_hotel")
    public Integer getTotalCountByUid(@Param("uid")Integer uid);
}
