package com.project.pojo;

import lombok.Data;
//用于导游信息管理系统的guiders表
@Data
public class Guider {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String phone;
    private int work_exp;

    public Guider(int id, String name, int age, String sex, String phone, int work_exp) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.work_exp = work_exp;
    }

    public Guider() {
    }

    @Override
    public String toString() {
        return "Guider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", work_exp=" + work_exp +
                '}';
    }
}
