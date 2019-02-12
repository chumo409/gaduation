package com.yhl.dao;

import com.yhl.domain.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsDao {

    @Select("select * from tab_goods limit #{start},#{end}")
    public List<Goods> getGoodsByPage(@Param("start")Integer start,@Param("end")Integer end);


    @Select("select count(*) from tab_goods")
    public  Integer getGoodsCount();
}
