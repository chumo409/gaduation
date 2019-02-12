package com.yhl.controller;

import com.yhl.domain.ResultInfo;
import com.yhl.domain.User;
import com.yhl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    HttpServletRequest request;
    @Autowired

    private UserService userService;
    @RequestMapping("/Register")
    public @ResponseBody ResultInfo Register(@RequestBody User user){
        ResultInfo info=new ResultInfo();

        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");

        System.out.println(user.getCode()+":"+checkcode_server);
        if (checkcode_server.equalsIgnoreCase(user.getCode())){
            User register = userService.Register(user);
            System.out.println(register);
            info.setFlag(true);
        }else {
           info.setFlag(false);
           info.setErrorMsg("验证码错误");
        }
        return info;
    }

    @RequestMapping("/ActiveUser")
    public @ResponseBody String ActiveUser(String ActiveCode){
       if (userService.ActiveUser(ActiveCode)){
           return "ok";
       }
       return "sorry";
    }
    @RequestMapping("/login")
    public @ResponseBody ResultInfo Login(@RequestBody User user, HttpServletRequest request){
        ResultInfo info=new ResultInfo();
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");

        System.out.println(user.getCode()+":"+checkcode_server);
        if (!checkcode_server.equalsIgnoreCase(user.getCode())){
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        }
        else {
            info=userService.Login(user,request);
        }
        return info;
    }


    @RequestMapping("/getLoginUser")
    public @ResponseBody User getLoginUser(HttpServletRequest request){
       return (User) request.getSession().getAttribute("loginUser");
    }

    @RequestMapping("/ExitLoginUser")
    public  void ExitLoginUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
         request.getSession().removeAttribute("loginUser");
        //使用springMVC控制跳转会导致返回页面失去样式
        response.sendRedirect(request.getContextPath()+"/index.html");

    }

    /***
     * 判断用户名是否可用
     * @param username
     * @return
     * @throws IOException
     */
    @RequestMapping("/CheckUserName")
    public @ResponseBody  ResultInfo CheckUserName(String username) {
        System.out.println(username);
        ResultInfo info=new ResultInfo();
        if (userService.checkUserName(username)!=null){
            info.setErrorMsg("用户名已存在，请换一个试试");
            info.setFlag(false);
        }else {
            info.setFlag(true);
            info.setErrorMsg("用户名可用");
        }
        return info;
    }


    @RequestMapping("/testString")
    public ModelAndView testString(HttpServletResponse response) throws IOException {
        return null;
    }


}
