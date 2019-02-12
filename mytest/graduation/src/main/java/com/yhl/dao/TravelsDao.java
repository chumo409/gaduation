package com.yhl.dao;

import com.yhl.domain.Travels;
import com.yhl.domain.TravelsImage;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TravelsDao {


    @Select("select * from tab_travels limit #{start},#{end}")
    @Results(value = {
            @Result( id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "time",property = "time"),
            @Result(column = "praise",property = "praise"),
            @Result(column = "id",property = "imageList",
                    many =@Many(select = "com.yhl.dao.TravelsDao.getImageById"))
    }
    )
    public List<Travels> getTravelByPage(@Param("start")Integer start,@Param("end") Integer end);

    @Select("select * from tab_travels_image where tid=#{id} limit 0,3")
    public  List<TravelsImage> getImageById(@Param("id") Integer id);

    @Select("select count(*) from tab_travels")
    public Integer getTotalTravelsCount();
}
