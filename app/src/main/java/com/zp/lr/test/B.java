package com.zp.lr.test;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/11
 * @Description:
 */
public class B {
    static {
        System.out.println("***static load B****");
    }

    public B(){
        System.out.println("***init load B****");
    }
}
