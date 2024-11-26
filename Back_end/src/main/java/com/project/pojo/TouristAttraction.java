package com.project.pojo;

import lombok.Data;
//用于旅游景点管理系统tourist_attraction表
@Data
public class TouristAttraction {
    private int id;
    private String name;
    private String address;
    private int maxParking;
    private int maxPeople;
    private String manager;
    private String managerPhone;

    public TouristAttraction(int id, String name, String address, int maxParking, int maxPeople, String manager, String managerPhone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.maxParking = maxParking;
        this.maxPeople = maxPeople;
        this.manager = manager;
        this.managerPhone = managerPhone;
    }

    public TouristAttraction() {
    }
}
