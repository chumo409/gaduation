package com.yhl.service;

import com.yhl.dao.ScenicDao;
import com.yhl.domain.PageBean;
import com.yhl.domain.Scenic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scenicService")
public class ScenicService {

    @Autowired
    private ScenicDao scenicDao;

    public PageBean<Scenic> getScenics(Integer cid,Integer currentPage,Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=6;
        }
        Integer start=(currentPage-1)* rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        if (cid==0){
            List scenic=scenicDao.getAllScenicByPage(start,end);
            pb.setList(scenic);
            Integer totalCount=scenicDao.getScenicCount();
            Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
            pb.setTotalPage(totalPage);
            pb.setTotalCount(totalCount);
            pb.setCurrentPage(currentPage);
            pb.setRows(rows);
        }
        else {
           List list=scenicDao.getScenicByPage(cid,start,end);
           Integer totalCount=scenicDao.getScenicCountByCid(cid);
           Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
           pb.setRows(rows);
           pb.setCurrentPage(currentPage);
           pb.setTotalCount(totalCount);
           pb.setTotalPage(totalPage);
           pb.setList(list);
        }
        return pb;
    }

}
