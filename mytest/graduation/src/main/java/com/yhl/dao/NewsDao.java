package com.yhl.dao;

import com.yhl.domain.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsDao {
    @Select("select * from tab_news order by time limit #{start},#{end}")
    public List<News>  getAllNews(@Param("start") Integer start, @Param("end") Integer end);

    @Select("select count(*) from tab_news")
    public Integer getTotalCountNews();

}
