package com.yhl.domain;

public class Scenic {
    private Integer id;
    private String name;
    private String descript;
    private String image;
    private Integer price;
    private Integer sid;
    private Integer cid;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Scenic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descript='" + descript + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", sid=" + sid +
                ", cid=" + cid +
                '}';
    }
}
