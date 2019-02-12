package com.yhl.domain;

import java.io.Serializable;

public class Hotel implements Serializable {
    private Integer id;
    private String name;
    private Integer star;
    private String desdcribt;
    private Integer price;
    private String logo;
    private String address;
    private Integer tel;

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

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getDesdcribt() {
        return desdcribt;
    }

    public void setDesdcribt(String desdcribt) {
        this.desdcribt = desdcribt;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}