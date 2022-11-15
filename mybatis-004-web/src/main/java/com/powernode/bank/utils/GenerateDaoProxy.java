package com.powernode.bank.utils;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 动态生成DAO的实现类
 *
 * @author powernode
 * @version 1.0
 * @since 1.0
 */
public class GenerateDaoProxy {
    /**
     * 生成DAO的实现类
     *
     * @param daoInterface DAO接口
     * @return
     */
    public static Object generate(SqlSession sqlSession, Class daoInterface) {
        //类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass(daoInterface.getName() + "Proxy");
        CtClass ctInterface = pool.makeInterface(daoInterface.getName());
        ctClass.addInterface(ctInterface);
        Method[] methods = daoInterface.getMethods();
        Arrays.stream(methods).forEach(method -> {
            try {
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public ");
                methodCode.append(method.getReturnType().getName());
                methodCode.append(" ");
                methodCode.append(method.getName());
                methodCode.append("(");
                Class[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    methodCode.append(parameterTypes[i].getName());
                    methodCode.append(" ");
                    methodCode.append("arg" + i);
                    if (i < parameterTypes.length - 1) {
                        methodCode.append(",");
                    }
                }
                methodCode.append("){");
                //方法体中的代码
                methodCode.append("org.apache.ibatis.session.SqlSession sqlSession = com.powernode.bank.utils.MyBatisUtils.getSqlSession();");
                String sqlId = daoInterface.getName() + "." + method.getName();
                SqlCommandType sqlCommandType = sqlSession.getConfiguration().
                        getMappedStatement(sqlId).getSqlCommandType();
                if (sqlCommandType == SqlCommandType.INSERT) {

                }

                if (sqlCommandType == SqlCommandType.DELETE) {

                }

                if (sqlCommandType == SqlCommandType.UPDATE) {
                    methodCode.append("return sqlSession.update(\"" + sqlId + "\", arg0);");
                }

                if (sqlCommandType == SqlCommandType.SELECT) {
                    String returnTypeName = method.getReturnType().getName();
                    methodCode.append("return ("+returnTypeName+")sqlSession.selectOne(\"" + sqlId + "\", arg0);");
                }


                methodCode.append("}");
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Object o = null;
        try {
            Class<?> clazz = ctClass.toClass();
            o = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }
}
