package com.yhl.controller;

import com.yhl.domain.PageBean;
import com.yhl.domain.Travels;
import com.yhl.service.TravelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/travels")
public class TravelsController {

    @Autowired
    private TravelsService travelsService;
    @RequestMapping("/getTravelsByPage")
    public @ResponseBody
    PageBean getTravelsByPage(Integer currentPage,Integer rows){
       return travelsService.getTravelsByPage(currentPage,null);
    }
}
