package com.yhl.service;

import com.yhl.dao.TravelsDao;
import com.yhl.domain.PageBean;
import com.yhl.domain.Travels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("travelsService")
public class TravelsService {
    @Autowired
    private TravelsDao travelsDao;

    public PageBean getTravelsByPage(Integer currentPage, Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }

        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        Integer totalCount=travelsDao.getTotalTravelsCount();
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        List travelsList=travelsDao.getTravelByPage(start,end);
        pb.setList(travelsList);

        return pb;


    }

}
