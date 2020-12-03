package com.zp.lr.test;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/11
 * @Description:
 */
public class TestJDKClassLoader {

    public static void main(String[] args) {
        /*System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassloader = appClassLoader.getParent();
        ClassLoader bootClassloader = extClassloader.getParent();


        System.out.println("bootClassloader :"+bootClassloader);
        System.out.println("extClassloader :"+extClassloader);
        System.out.println("appClassLoader :"+appClassLoader);
        System.out.println("boot load path");
        URL[] bootPath = Launcher.getBootstrapClassPath().getURLs();
        for(URL url : bootPath){
            System.out.println(url.toString());
        }

        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("appClassLoader加载以下文件：");*/


    }
}
