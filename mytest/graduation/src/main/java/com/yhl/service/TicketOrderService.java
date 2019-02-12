package com.yhl.service;

import com.yhl.dao.TicketDao;
import com.yhl.dao.TicketOrderDao;
import com.yhl.domain.OrderTicket;
import com.yhl.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ticketOrderService")
public class TicketOrderService {

    @Autowired
    private TicketOrderDao ticketOrderDao;


    public PageBean<OrderTicket> getTicketOrderByUid(Integer uid, Integer currentPage, Integer rows){

        PageBean pb=new PageBean();

        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        Integer start=(currentPage-1)*rows;
        Integer end= start+rows;
        Integer totalCount=ticketOrderDao.getTicketCountByUid(uid);
        pb.setTotalCount(totalCount);
        Integer totalPage=totalCount%rows==0? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        List OrderList=ticketOrderDao.getTicketOrderByUid(uid,start,end);
        pb.setList(OrderList);
        return pb;

    }
}
