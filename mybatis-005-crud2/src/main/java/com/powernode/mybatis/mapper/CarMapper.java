package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;

import java.util.List;

public interface CarMapper {
    int insertCar(Car car);
    int deleteCarById(Long id);
    int updateCar(Car car);
    Car selectCarById(Long id);
    List<Car> selectAllCars();
}
