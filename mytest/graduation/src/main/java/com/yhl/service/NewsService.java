package com.yhl.service;

import com.yhl.dao.NewsDao;
import com.yhl.domain.News;
import com.yhl.domain.PageBean;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("newsService")
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public PageBean getNewsByPage(Integer currentPage, Integer rows){
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
        Integer totalCount=newsDao.getTotalCountNews();
        Integer totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        List newsList=newsDao.getAllNews(start,end);
        pb.setList(newsList);
        return pb;
    }

}
