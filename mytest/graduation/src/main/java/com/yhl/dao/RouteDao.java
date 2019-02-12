package com.yhl.dao;

import com.yhl.domain.Route;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RouteDao {
    /**
     * 查询首页精选线路 cid为1
     * @return
     */
    @Select("SELECT * FROM tab_route where cid=1 order by date LIMIT 0,7")
    public List<Route> getIndexRoute();

    /**
     * 查询首页国内线路  cid为2
     * @return
     */
    @Select("SELECT * FROM tab_route where cid=2 order by date LIMIT 0,7")
    public List<Route> getIndexRoute_gn();

    /***
     * 查询一日游线路
     * @param start
     * @param end
     * @return
     */
    @Select("select * from tab_route where cid=#{cid} order by date limit #{start},#{end}")
    public  List<Route> getSpecialRouteByCid(@Param("cid") Integer cid,@Param("start") Integer start, @Param("end") Integer end);

    @Select("select count(*) from tab_route where cid=#{cid}")
    public Integer getSpecialRouteCount(@Param("cid")Integer cid);
    @Select("select count(*) from tab_route")
    public Integer getTotalRouteCount();

    @Select("select * from tab_route  order by date limit #{start},#{end}")
    public  List<Route> getSpecialRoute(@Param("start") Integer start, @Param("end") Integer end);


}
