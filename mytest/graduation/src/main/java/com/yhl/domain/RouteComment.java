package com.yhl.domain;

import java.io.Serializable;
import java.util.Date;

public class RouteComment implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer rid;
    private Date time;
    private Integer servicestar;
    private Integer schedulingstar;
    private Integer scenestar;
    private String content;
    private Integer praise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getServicestar() {
        return servicestar;
    }

    public void setServicestar(Integer servicestar) {
        this.servicestar = servicestar;
    }

    public Integer getSchedulingstar() {
        return schedulingstar;
    }

    public void setSchedulingstar(Integer schedulingstar) {
        this.schedulingstar = schedulingstar;
    }

    public Integer getScenestar() {
        return scenestar;
    }

    public void setScenestar(Integer scenestar) {
        this.scenestar = scenestar;
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