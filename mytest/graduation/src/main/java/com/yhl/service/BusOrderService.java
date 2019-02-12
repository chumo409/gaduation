package com.yhl.service;

import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import com.yhl.dao.BusOrderDao;
import com.yhl.domain.OrderSeeingbus;
import com.yhl.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("busOrderService")
public class BusOrderService {

    @Autowired
    private BusOrderDao busOrderDao;

    public PageBean<OrderSeeingbus> getBusOrderByPage(Integer uid,Integer currentPage,Integer rows){
        PageBean pb=new PageBean();

        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        Integer totalCount=busOrderDao.getBusCountByUid(uid);
        pb.setTotalCount(totalCount);
        Integer totalPage=totalCount%rows==0? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        Integer start=(currentPage-1)* rows;
        Integer end= start+rows;
        List BusOrderList=busOrderDao.getBusOrderByUid(uid,start,end);
            pb.setList(BusOrderList);
        return  pb;


    }
}
