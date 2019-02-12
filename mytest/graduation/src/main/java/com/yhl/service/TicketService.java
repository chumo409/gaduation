package com.yhl.service;


import com.yhl.dao.SeeingBusDao;
import com.yhl.dao.TicketDao;
import com.yhl.domain.PageBean;
import com.yhl.domain.Seeingbus;
import com.yhl.domain.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ticketService")
public class TicketService {
    @Autowired
    private TicketDao ticketDao;

    public PageBean getTicketByPage(Integer currentPage, Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        Integer totalCount=ticketDao.getTicketCount();
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;

        pb.setTotalPage(totalPage);
        pb.setTotalCount(totalCount);
        List GuiderList=ticketDao.getTicketByPage(start,end);
        pb.setList(GuiderList);
        return pb;
    }
}
