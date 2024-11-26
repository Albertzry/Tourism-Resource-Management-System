package com.project.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

//用于停车管理系统parking表
@Data
public class Parking {

    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Timestamp parking_time;
    private String car_num;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Timestamp leave_time;

    public Parking(int id, String car_num, Timestamp parking_time, Timestamp leave_time) {
        this.id = id;
        this.car_num = car_num;
        this.parking_time = parking_time;
        this.leave_time = leave_time;
    }

    public Parking() {
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", parking_time=" + parking_time +
                ", car_num='" + car_num + '\'' +
                ", leave_time=" + leave_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getParking_time() {
        return parking_time;
    }

    public void setParking_time(Timestamp parking_time) {
        this.parking_time = parking_time;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public Timestamp getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(Timestamp leave_time) {
        this.leave_time = leave_time;
    }
}

