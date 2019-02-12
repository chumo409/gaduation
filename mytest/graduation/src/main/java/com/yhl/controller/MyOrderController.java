package com.yhl.controller;

import com.github.pagehelper.Page;
import com.yhl.domain.PageBean;
import com.yhl.domain.User;
import com.yhl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class MyOrderController {
    @Autowired
    private BusOrderService busOrderService;
    @Autowired
    private GuiderOrderService guiderOrderService;
    @Autowired
    private HotelOrderService hotelOrderService;
    @Autowired
    private TicketOrderService ticketOrderService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/getMyOrderByPage")
    public @ResponseBody PageBean getMyOrderByPage(Integer cid, Integer currentPage, Integer rows){
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        Integer uid=loginUser.getId();
        if (cid==1){
            return ticketOrderService.getTicketOrderByUid(uid,currentPage,rows);
        }
        if (cid==2){
            return hotelOrderService.getHotelOrderByPage(uid,currentPage,rows);
        }
        if (cid==3){
            return busOrderService.getBusOrderByPage(uid,currentPage,rows);
        }
        else {
            return guiderOrderService.getGuiderOrderByPage(uid,currentPage,rows);
        }
    }





}
