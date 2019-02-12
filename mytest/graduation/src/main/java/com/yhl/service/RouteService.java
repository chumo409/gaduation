package com.yhl.service;

import com.yhl.dao.RouteDao;
import com.yhl.domain.PageBean;
import com.yhl.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("routeService")
public class RouteService {
    @Autowired
    private RouteDao routeDao;


    public List<Route> getIndexRoute(){
        return routeDao.getIndexRoute();
    }
    public List<Route> getIndexRoute_gn(){
        return routeDao.getIndexRoute_gn();
    }

    public PageBean getSpecialRoute(Integer cid,Integer currentPage,Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=6;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;

        PageBean pb=new PageBean();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        if (cid==null){
            Integer totalCount=routeDao.getTotalRouteCount();
            Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
            pb.setTotalCount(totalCount);
            pb.setTotalPage(totalPage);
            List AllList=routeDao.getSpecialRoute(start,end);
            pb.setList(AllList);
        }else {
            Integer totalCount=routeDao.getSpecialRouteCount(cid);
            Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
            pb.setTotalPage(totalPage);
            pb.setTotalCount(totalCount);
            List list=routeDao.getSpecialRouteByCid(cid,start,end);
            pb.setList(list);
        }

        return pb;
    }
}
