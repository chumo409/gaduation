package com.yhl.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Travels implements Serializable {
    private Integer id;
    private Integer uid;
    private String title;
    private String content;
    private String time;
    private Integer praise;
    private List<TravelsImage> imageList;

    public List<TravelsImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<TravelsImage> imageList) {
        this.imageList = imageList;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getPraise() {
        return praise;
    }

    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    @Override
    public String toString() {
        return "Travels{" +
                "id=" + id +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", praise=" + praise +
                ", imageList=" + imageList +
                '}';
    }
}