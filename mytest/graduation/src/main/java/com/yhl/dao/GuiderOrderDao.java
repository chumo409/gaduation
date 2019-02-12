package com.yhl.dao;


import com.yhl.domain.OrderGuider;
import com.yhl.domain.OrderTicket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GuiderOrderDao {


    @Select("select * from tab_order_guider where uid=#{uid} limit #{start},#{end}")
    public List<OrderGuider> getGuiderOrderByUid(@Param("uid") Integer uid,
                                                 @Param("start") Integer start, @Param("end")Integer end);


    @Select("select count(*) from tab_order_guider")
    public Integer getGuiderCountByUid(@Param("uid")Integer uid);



}


