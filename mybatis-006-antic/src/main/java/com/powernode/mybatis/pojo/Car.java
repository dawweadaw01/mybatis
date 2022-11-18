package com.powernode.mybatis.pojo;

import lombok.Data;

@Data
public class Car {
    private Long id;
    private String car_num;
    private String brand;
    private Double guide_price;
    private String produce_time;
    private String car_type;

    public Car() {
    }

    public Car(Long id, String car_num, String brand, Double guide_price, String produce_time, String car_type) {
        this.id = id;
        this.car_num = car_num;
        this.brand = brand;
        this.guide_price = guide_price;
        this.produce_time = produce_time;
        this.car_type = car_type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car_num='" + car_num + '\'' +
                ", brand='" + brand + '\'' +
                ", guide_price=" + guide_price +
                ", produce_time='" + produce_time + '\'' +
                ", car_type='" + car_type + '\'' +
                '}';
    }
}
