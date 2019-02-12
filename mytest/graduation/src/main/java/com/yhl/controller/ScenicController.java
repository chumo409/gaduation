package com.yhl.controller;

import com.yhl.domain.PageBean;
import com.yhl.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/scenic")
public class ScenicController {

    @Autowired
    private ScenicService scenicService;

    @RequestMapping("/getScenics")
    public @ResponseBody PageBean getScenics(Integer cid, Integer currentPage, Integer rows){
        return scenicService.getScenics(cid,currentPage,rows);
    }
}
