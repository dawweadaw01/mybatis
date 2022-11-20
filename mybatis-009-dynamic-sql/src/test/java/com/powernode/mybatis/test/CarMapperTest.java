package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarMapperTest {
    @Test
    public void testDeleteById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {209L, 210L, 211L};
        int i = mapper.deleteById(ids);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertBatch() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = new Car(null,"1200","奥迪", 100000.0,"2020-11-11", "SUV");
        Car car2 = new Car(null,"1200","奥迪1", 100000.0,"2020-11-11", "SUV");
        Car car3 = new Car(null,"1200","奥迪2", 100000.0,"2020-11-11", "SUV");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        carMapper.insertBatch(cars);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void selectByMultiConditionWithWhere() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByMultiConditionWithWhere("", null, "");
        for (Car car : cars) {
            System.out.println(car);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectByMultiCondition() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByMultiCondition("", null, "");
        for (Car car : cars) {
            System.out.println(car);
        }
        SqlSessionUtil.closeSession();
    }
}
