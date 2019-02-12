package com.yhl.service;

import com.yhl.dao.GoodsDao;
import com.yhl.dao.SnackDao;
import com.yhl.domain.PageBean;
import com.yhl.domain.Snack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("localService")
public class LocalService {

    @Autowired
    private SnackDao snackDao;

    @Autowired
    private GoodsDao goodsDao;


    public PageBean getSnackByPage(Integer cid,Integer currentPage, Integer rows){
        if (currentPage==null){
            currentPage=1;
        }
        if (rows==null){
            rows=5;
        }
        Integer start=(currentPage-1)*rows;
        Integer end=start+rows;
        PageBean pb=new PageBean();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        if (cid==1){
            Integer totalCount=snackDao.getSnackCount();
            Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
            pb.setTotalPage(totalPage);
            pb.setTotalCount(totalCount);
            List snackList=snackDao.getSnacksByPage(start,end);
            pb.setList(snackList);
        }
        else {
            Integer totalCount=goodsDao.getGoodsCount();
            Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
            pb.setTotalCount(totalCount);
            pb.setTotalPage(totalPage);
            List goodsList=goodsDao.getGoodsByPage(start,end);
            pb.setList(goodsList);
        }

        return  pb;
    }
}
