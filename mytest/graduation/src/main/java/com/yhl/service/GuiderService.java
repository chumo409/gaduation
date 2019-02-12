package com.yhl.service;

import com.yhl.dao.GuiderDao;
import com.yhl.domain.Guider;
import com.yhl.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("guiderService")
public class GuiderService {
    @Autowired
    private GuiderDao guiderDao;

    public PageBean getGuiderByPage(Integer currentPage, Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        Integer totalCount=guiderDao.getGuiderCount();
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;

        pb.setTotalPage(totalPage);
        pb.setTotalCount(totalCount);
        List GuiderList=guiderDao.getTicketByPage(start,end);
        pb.setList(GuiderList);
        return pb;
    }
}
