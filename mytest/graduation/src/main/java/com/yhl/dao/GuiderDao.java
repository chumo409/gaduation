package com.yhl.dao;

import com.yhl.domain.Guider;
import com.yhl.domain.Ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GuiderDao {

    @Select("select * from tab_guider limit #{start},#{end}")
    public List<Guider> getTicketByPage(@Param("start")Integer start, @Param("end") Integer end);

    @Select("select count(*) from tab_guider")
    public Integer getGuiderCount();
}
