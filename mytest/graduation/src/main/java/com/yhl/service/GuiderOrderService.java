package com.yhl.service;

import com.yhl.dao.GuiderDao;
import com.yhl.dao.GuiderOrderDao;
import com.yhl.domain.OrderGuider;
import com.yhl.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("guiderOrderService")
public class GuiderOrderService {

    @Autowired
    private GuiderOrderDao guiderOrderDao;


    public PageBean<OrderGuider> getGuiderOrderByPage(Integer uid,Integer currentPage,Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        PageBean pb=new PageBean();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        Integer totalCount=guiderOrderDao.getGuiderCountByUid(uid);
        pb.setTotalCount(totalCount);
        Integer totalPage=totalCount%rows==0? totalCount/rows:totalCount/rows+1;
        pb.setTotalPage(totalPage);
        Integer start= (currentPage-1)* rows;
        Integer end=start+rows;
        List GuiderOrderList =guiderOrderDao.getGuiderOrderByUid(uid,start,end);
        pb.setList(GuiderOrderList);
        return  pb;

    }
}
