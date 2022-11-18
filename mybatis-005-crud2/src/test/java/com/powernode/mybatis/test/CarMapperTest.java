package com.powernode.mybatis.test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "京A12", "奥迪",
                100000.0, "2020-01-01", "SUV");
        int count = carMapper.insertCar(car);
        System.out.println("count = " + count);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        int count = carMapper.deleteCarById(205L);
        sqlSession.commit();
        System.out.println(count);
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(206L, "京A12345", "法拉利",
                100000.0, "2020-01-01", "SUV");
        int count = carMapper.updateCar(car);
        sqlSession.commit();
        System.out.println(count);
    }
    @Test
    public void testSelectById(){
SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car1 = carMapper.selectCarById(206L);
        System.out.println(car1);
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        carMapper.selectAllCars().forEach(System.out::println);
    }
}
