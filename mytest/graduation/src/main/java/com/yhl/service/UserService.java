package com.yhl.service;

import com.yhl.dao.UserDao;
import com.yhl.domain.ResultInfo;
import com.yhl.domain.User;
import com.yhl.util.MailUtils;
import com.yhl.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("userSercice")
public class UserService {

    @Autowired
    private UserDao userDao;

    public User Register(User user){
        System.out.println("service执行了");
        user.setCode(UuidUtil.getUuid());
        user.setState("N");
        MailUtils.sendMail(user.getEmail(),"<a href='localhost:8080/user/ActiveUser?ActiveCode="+user.getCode()+"'>点我激活</a>","这是一封激活邮件");
        userDao.Register(user);
        return user;
    }

    public Boolean ActiveUser(String activeCode){
        try {
            userDao.ActiveUser(activeCode);
        } catch (Exception e) {
            System.out.println("激活出现异常");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultInfo Login(User user, HttpServletRequest request){
        ResultInfo info=new ResultInfo();
        User useIsExist = userDao.CheckUseIsExist(user);
        if (useIsExist==null){
            info.setFlag(false);
            info.setErrorMsg("用户不存在");
        }else {
            User loginUser = userDao.Login(user);
            if (loginUser==null){
                info.setFlag(false);
                info.setErrorMsg("密码错误");
            }else if (loginUser!=null&&loginUser.getState()=="N"){
                info.setFlag(false);
                info.setErrorMsg("用户尚未激活");
            }else {
                info.setFlag(true);
                info.setErrorMsg("验证通过");
                request.getSession().setAttribute("loginUser",loginUser);
                info.setData(loginUser);
            }
        }
        return info;
    }

    public User checkUserName(String username){
        User user=new User();
        user.setUsername(username);
        return userDao.CheckUseIsExist(user);
    }

}

