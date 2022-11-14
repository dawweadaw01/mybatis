package com.powernode.junit.service;

import org.junit.Assert;
import org.junit.Test;

public class MathServiceTest {
    @Test
    public void testSum() {
        MathService mathService = new MathService();
        //实际值
        int sum = mathService.sum(1, 2);
        //期望值
        int expected = 30;
        //加断言进行测试
        Assert.assertEquals(expected, sum);
    }
    @Test
    public void testSub() {
        MathService mathService = new MathService();
        int sub = mathService.sub(1, 2);
        int expected = -1;
        //断言测试
        Assert.assertEquals(expected, sub);
        System.out.println(sub);
    }
}
