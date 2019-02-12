package com.yhl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myTest")
public class myController {
    @RequestMapping("/testString")
    public String testString(){
        return "login";
    }
}
