package com.yhl.service;

import com.yhl.dao.HotelDao;
import com.yhl.domain.Hotel;
import com.yhl.domain.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("hotelService")
public class HotelService {
    @Autowired
    private HotelDao hotelDao;

    public PageBean getHotelByPage(Integer currentPage,Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        Integer totalCount=hotelDao.getHotelCount();
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;

        pb.setTotalPage(totalPage);
        pb.setTotalCount(totalCount);
        List GuiderList=hotelDao.getHotelByPage(start,end);
        pb.setList(GuiderList);
        return pb;
    }
}
