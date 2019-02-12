package com.yhl.controller;

import com.github.pagehelper.Page;
import com.yhl.domain.Guider;
import com.yhl.domain.Hotel;
import com.yhl.domain.PageBean;
import com.yhl.service.GuiderService;
import com.yhl.service.HotelService;
import com.yhl.service.SeeingBusService;
import com.yhl.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private GuiderService guiderService;

    @Autowired
    private HotelService hotelService;
    @Autowired
    private SeeingBusService seeingBusService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/getServiceByPage")
    public @ResponseBody
    PageBean getServiceByPage(Integer cid, Integer currentPage, Integer rows) {


        if (cid==null){
            cid=1;
        }
        if (currentPage==null){currentPage=1;}
        if (rows==null){rows=6;}

        if (cid == 1) {
            return hotelService.getHotelByPage(currentPage, rows);
        }
        if (cid == 2) {
            return ticketService.getTicketByPage(currentPage,rows);
        }
        if (cid==3){
            return seeingBusService.getSeeintBusByPage(currentPage,rows);
        }

        else {
            return guiderService.getGuiderByPage(currentPage,rows);
        }

    }
}
