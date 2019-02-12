package com.yhl.dao;

import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import com.yhl.domain.Scenic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScenicDao {
    @Select("select * from tab_scenic where cid=#{cid} limit #{start},#{end}")
    public List<Scenic> getScenicByPage(@Param("cid") Integer cid, @Param("start") Integer start, @Param("end") Integer end);

    @Select("select count(*) from tab_scenic")
    public Integer getScenicCount();


    @Select("select count(*) from tab_scenic where cid=#{cid}")
    public Integer getScenicCountByCid(@Param("cid")Integer cid);

    @Select("select * from tab_scenic  limit #{start},#{end}")
    public List<Scenic> getAllScenicByPage(@Param("start") Integer start, @Param("end") Integer end);

}
