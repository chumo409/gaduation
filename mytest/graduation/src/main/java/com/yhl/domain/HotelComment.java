package com.yhl.domain;

import java.io.Serializable;

public class HotelComment implements Serializable {
    private Integer id;
    private Integer hid;
    private String ordertype;
    private Integer servicestar;
    private Integer hygienestar;
    private String content;
    private Integer praise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public Integer getServicestar() {
        return servicestar;
    }

    public void setServicestar(Integer servicestar) {
        this.servicestar = servicestar;
    }

    public Integer getHygienestar() {
        return hygienestar;
    }

    public void setHygienestar(Integer hygienestar) {
        this.hygienestar = hygienestar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }
}