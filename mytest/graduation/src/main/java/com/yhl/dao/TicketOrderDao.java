package com.yhl.dao;

import com.yhl.domain.OrderTicket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TicketOrderDao {

    @Select("select * from tab_order_ticket where uid=#{uid} limit #{start},#{end}")
    public List<OrderTicket> getTicketOrderByUid(@Param("uid") Integer uid,
                                                @Param("start") Integer start,@Param("end")Integer end);


    @Select("select count(*) from tab_order_ticket")
    public Integer getTicketCountByUid(@Param("uid")Integer uid);
}
