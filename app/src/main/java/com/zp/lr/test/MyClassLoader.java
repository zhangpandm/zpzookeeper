package com.zp.lr.test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/11
 * @Description:
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath){
        this.classPath=classPath;
    }


    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
         //   e.printStackTrace();
            if(e instanceof IOException)
               throw new ClassNotFoundException();

        }
        return null;
    }

    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();


                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    try {
                        c = findClass(name);
                    } catch (Exception e) {
                      //  e.printStackTrace();
                        if(e instanceof ClassNotFoundException){
                           c = super.getParent().loadClass(name);
                        }else {
                            throw new ClassNotFoundException();
                        }

                    }

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }

    private byte[] loadByte(String name) throws IOException {
        name = name.replaceAll("\\.","/");
        FileInputStream fis = new FileInputStream(this.classPath+"/"+name+".class");
        int leth = fis.available();
        byte[] data = new byte[leth];
        fis.read(data);
        fis.close();
        return data;
    }
}
