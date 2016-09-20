package com.ys.demo.po;

import java.util.Date;

/**
 * Created by yangshe on 2016/9/19.
 */
public class Books {
    private Integer book_id;
    private String book_name;
    private String type;
    private String content;
    private double price;
    private String cover;
    private byte state;
    private String add_user;
    private String rent_user;
    private String add_time;

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getRent_user() {
        return rent_user;
    }

    public void setRent_user(String rent_user) {
        this.rent_user = rent_user;
    }

    public String getAdd_user() {
        return add_user;
    }

    public void setAdd_user(String add_user) {
        this.add_user = add_user;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", cover='" + cover + '\'' +
                ", state=" + state +
                ", add_user='" + add_user + '\'' +
                ", rent_user='" + rent_user + '\'' +
                ", add_time=" + add_time +
                '}';
    }
}
