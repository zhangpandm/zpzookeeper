package com.zp.lr.test;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/11
 * @Description:
 */
public class A {
    static {
        System.out.println("***static load A****");
    }

    public A(){
        System.out.println("***init load A****");
    }

    public void sayHello(){
        System.out.println("A Say hello!");
    }
}
