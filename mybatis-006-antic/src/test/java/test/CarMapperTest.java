package test;

import com.powernode.mybatis.mapper.CarMapper;
import com.powernode.mybatis.pojo.Car;
import com.powernode.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CarMapperTest {
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
