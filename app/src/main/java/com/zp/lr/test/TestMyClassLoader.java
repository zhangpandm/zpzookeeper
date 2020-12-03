package com.zp.lr.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/11
 * @Description:
 */
public class TestMyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException,NoSuchMethodException,InvocationTargetException, IllegalAccessException, InstantiationException {
        MyClassLoader classLoader1 = new MyClassLoader("G:\\jps1");
        Class clas1 = classLoader1.loadClass("com.zp.lr.test.A",false);
        Object obj1=clas1.newInstance();
        System.out.println(clas1.getClassLoader());

        MyClassLoader classLoader2 = new MyClassLoader("G:\\jper");
        Class clas2 = classLoader2.loadClass("com.zp.lr.test.A",false);
        Object obj2=clas2.newInstance();
        Method method = clas2.getDeclaredMethod("sayHello",null);
        method.invoke(obj2,null);
        System.out.println(clas2.getClassLoader());
    }
}
