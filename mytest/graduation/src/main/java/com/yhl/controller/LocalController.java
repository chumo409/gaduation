package com.yhl.controller;

import com.yhl.domain.PageBean;
import com.yhl.domain.Snack;
import com.yhl.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/local")
public class LocalController {

    @Autowired
    private LocalService localService;



    @RequestMapping("/getLocalByPage")
    public @ResponseBody
    PageBean getSnackByPage(Integer cid,Integer currentPage,Integer rows){
     return    localService.getSnackByPage(cid,currentPage,rows);
    }

}
