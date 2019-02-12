package com.yhl.service;

import com.yhl.dao.HotelOrderDao;
import com.yhl.domain.OrderHotel;
import com.yhl.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelOrderService")
public class HotelOrderService {

    @Autowired
    private HotelOrderDao hotelOrderDao;


    public PageBean<OrderHotel> getHotelOrderByPage(Integer uid,Integer currentPage,Integer rows){
        PageBean pb=new PageBean();
        Integer totalCount = hotelOrderDao.getTotalCountByUid(uid);
        pb.setTotalCount(totalCount);
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        List HotelOrderList=hotelOrderDao.getTicketOrderByUid(uid,start,end);
        pb.setList(HotelOrderList);
        return  pb;

    }
}
