package com.project.pojo;

import lombok.Data;
//用于酒店信息hotel表
@Data
public class Hotel {

    private int id;
    private String name;
    private int capacity;        //可容纳客人数量
    private int level;
    private String phone;
    private String email;

    public Hotel(int id, String name, int capacity, int level, String phone, String email) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.level = level;
        this.phone = phone;
        this.email = email;
    }
}
