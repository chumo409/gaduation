package com.yhl.dao;

import com.yhl.domain.Hotel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import java.util.List;

public interface HotelDao {

    @Select("select * from tab_hotel limit #{start},#{end}")
    public List<Hotel> getHotelByPage(@Param("start") Integer start,@Param("end") Integer end);

    @Select("select count(*) from tab_hotel")
    public Integer getHotelCount();
}
