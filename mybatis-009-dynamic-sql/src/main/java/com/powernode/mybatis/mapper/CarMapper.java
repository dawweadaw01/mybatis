package com.powernode.mybatis.mapper;

import com.powernode.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {
    int deleteById(@Param("ids") Long[] id);
    int insertBatch(@Param("cars") List<Car> cars);
    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guide_price") Double guide_price, @Param("car_type") String car_type);
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guide_price") Double guide_price, @Param("car_type") String car_type);

}
