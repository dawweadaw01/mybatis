package com.powernode.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import org.junit.Test;

public class JavassistTest {
    @Test
    public void testGenerateFirstClass() {
        //获取类池生成class
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.powernode.bank.dao.impl.AccountDaoImpl");

    }
}
