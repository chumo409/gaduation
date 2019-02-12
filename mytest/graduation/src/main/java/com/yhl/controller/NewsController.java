package com.yhl.controller;

import com.yhl.domain.News;
import com.yhl.domain.PageBean;
import com.yhl.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/getNewsByPage")
    public @ResponseBody
    PageBean getNewsByPage(Integer currentPage){
        Integer rows=5;
       return newsService.getNewsByPage(currentPage,rows);
    }



}
