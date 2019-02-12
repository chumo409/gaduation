package com.yhl.domain;

import java.io.Serializable;

public class TravelsImage implements Serializable {
    private Integer id;
    private Integer tid;
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TravelsImage{" +
                "id=" + id +
                ", tid=" + tid +
                ", image='" + image + '\'' +
                '}';
    }
}