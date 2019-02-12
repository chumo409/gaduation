package com.yhl.dao;

import com.yhl.domain.Ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface TicketDao {

    @Select("select * from tab_ticket limit #{start},#{end}")
    public List<Ticket> getTicketByPage(@Param("start")Integer start, @Param("end")Integer end);

    @Select("select count(*) from tab_ticket")
    public  Integer getTicketCount();
}
