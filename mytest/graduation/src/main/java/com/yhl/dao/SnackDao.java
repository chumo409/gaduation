package com.yhl.dao;

import com.yhl.domain.Snack;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SnackDao {

    @Select("select * from tab_snack limit #{start},#{end}")
    public List<Snack> getSnacksByPage(@Param("start") Integer start,@Param("end")Integer end);


    @Select("select count(*) from tab_snack")
    public Integer getSnackCount();

}
