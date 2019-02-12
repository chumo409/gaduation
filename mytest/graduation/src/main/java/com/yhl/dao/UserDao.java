package com.yhl.dao;

import com.yhl.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


public interface UserDao {
    @Select("insert into tab_user(id,username,password,name,birthday,sex,tel,email,state,code) " +
            "values(null,#{username},#{password},#{name},#{birthday},#{sex},#{tel},#{email},#{state},#{code})")
    public void Register(User user);

    @Update("update tab_user set state='Y' where code=#{code}")
    public Integer ActiveUser(String activeCode);

    @Select("select * from tab_user where username=#{username} and password=#{password}")
    public User Login(User user);

    @Select("select * from tab_user where username=#{username}")
    public User CheckUseIsExist(User user);

}
