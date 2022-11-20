package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        PageHelper.startPage(1,2);
        List<Car> cars = carMapper.selectAll();
        for (Car car : cars) {
            System.out.println(car);
        }
        PageInfo<Car> pageInfo = new PageInfo<>(cars);
        System.out.println(pageInfo);
        sqlSession.close();
    }
    @Test
    public void TestInsertCarUseGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "京A12", "奥迪",
                100000.0, "2020-01-01", "SUV");
        int count = carMapper.insertCarUseGeneratedKeys(car);
        System.out.println(car);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByCar("迪");
        for (Car car : cars) {
            System.out.println(car);
        }
        sqlSession.close();

    }
    @Test
    public  void  testDeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        int i = carMapper.deleteBatch("206,207,208");
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByCarType() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper carMapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = carMapper.selectByCarType("SUV");
        for (Car car : cars) {
            System.out.println(car);
        }
        sqlSession.close();
    }
}
