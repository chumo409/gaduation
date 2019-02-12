package com.yhl.service;


import com.yhl.dao.SeeingBusDao;
import com.yhl.domain.PageBean;
import com.yhl.domain.Seeingbus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("seeingBusService")
public class SeeingBusService {
    @Autowired
    private SeeingBusDao seeingBusDao;

    public PageBean getSeeintBusByPage(Integer currentPage, Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        Integer totalCount=seeingBusDao.getBusCount();
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;

        pb.setTotalPage(totalPage);
        pb.setTotalCount(totalCount);
        List GuiderList=seeingBusDao.getBusByPage(start,end);
        pb.setList(GuiderList);
        return pb;
    }
}
