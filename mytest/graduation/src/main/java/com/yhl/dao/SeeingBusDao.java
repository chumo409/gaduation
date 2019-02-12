package com.yhl.dao;

import com.yhl.domain.Seeingbus;
import com.yhl.domain.Ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SeeingBusDao {

    @Select("select * from tab_seeingbus limit #{start},#{end}")
    public List<Seeingbus> getBusByPage(@Param("start")Integer start, @Param("end") Integer end);

    @Select("select count(*) from tab_seeingbus")
    public  Integer getBusCount();
}
