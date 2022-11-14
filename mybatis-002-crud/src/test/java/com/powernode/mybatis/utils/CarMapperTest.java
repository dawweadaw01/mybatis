package com.powernode.mybatis.utils;

import com.powernode.mybatis.utils.pojo.Car;
import org.apache.ibatis.session.SqlSession;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarMapperTest {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();

        List<Car> selectAll = sqlSession.selectList("1.selectAll");
        selectAll.forEach(car -> System.out.println(car));
//        for (Object o : selectAll) {
//            System.out.println(o);
//        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectCarById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object selectCarById = sqlSession.selectOne("selectCarById", 177);
        System.out.println(selectCarById);
        sqlSession.close();
    }
    @Test
    public void testUpdateCar() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car();
        car.setId(177L);
        car.setCar_num("京A12345");
        car.setBrand("奥迪");
        car.setGuide_price(100000.0);
        car.setProduce_time("2020-01-01");
        car.setCar_type("SUV");
        int i = sqlSession.update("updateCarById", car);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteCarById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int i = sqlSession.delete("deleteCarById", 176);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPoJo() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null, "京A12345", "法拉利", 100.0, "2019-01-01", "燃油车");
        int i = sqlSession.insert("insertCar", car);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void testInsertCar() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("car_num", 1005);
        map.put("brand", "宝马");
        map.put("guide_price", 50.00);
        map.put("produce_time", "2020-01-01");
        map.put("car_type", "燃油车");

        sqlSession.insert("insertCar", map);
        sqlSession.commit();
        sqlSession.close();
    }

}
