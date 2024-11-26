package com.project.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
//用于旅行社管理系统travel_agency表
@Data
public class TravelAgency {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date createTime;

    public TravelAgency(int id, String name, String phone, String email, String address, Date createTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.createTime = createTime;
    }

    public TravelAgency() {
    }
}
