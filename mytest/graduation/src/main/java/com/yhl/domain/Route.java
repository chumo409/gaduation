package com.yhl.domain;

import java.io.Serializable;
import java.util.Date;

public class Route implements Serializable {
    private Integer id;
    private String name;
    private Float price;
    private String introduce;
    private String flag;
    private Date date;
    private Integer cid;
    private Integer sid;
    private String rimage;

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", introduce='" + introduce + '\'' +
                ", flag='" + flag + '\'' +
                ", date=" + date +
                ", cid=" + cid +
                ", sid=" + sid +
                ", rimage='" + rimage + '\'' +
                '}';
    }
}