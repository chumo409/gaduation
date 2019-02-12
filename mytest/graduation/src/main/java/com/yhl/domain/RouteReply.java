package com.yhl.domain;

import java.io.Serializable;
import java.util.Date;

public class RouteReply  implements Serializable {
     private Integer id;
     private Integer uid;
     private String content;
     private Date time;
     private Integer cid;
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
     public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
     public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
     public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}