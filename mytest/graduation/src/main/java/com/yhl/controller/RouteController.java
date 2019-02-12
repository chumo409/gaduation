package com.yhl.controller;

import com.yhl.domain.PageBean;
import com.yhl.domain.Route;
import com.yhl.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @RequestMapping("/getIndexRoute")
    public @ResponseBody List<Route> getIndexRoute(){
        return routeService.getIndexRoute();
    }

    @RequestMapping("/getIndexRoute_gn")
    public @ResponseBody List<Route> getIndexRoute_gn(){
        return routeService.getIndexRoute_gn();
    }
    @RequestMapping("/getSpecialRoute")
    public @ResponseBody
    PageBean getSpecialRoute(Integer cid, Integer currentPage){
        System.out.println(cid);
        return routeService.getSpecialRoute(cid,currentPage,6);
    }
}
