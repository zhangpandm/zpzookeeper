package com.zp.lr.test;

import org.junit.Test;
import org.junit.rules.Stopwatch;

import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Auther: zhangpanm
 * @Date: 2020/8/14
 * @Description:
 */
public class AqsTest {

    @Test
    public void qs(){
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        long[] data = LongStream.rangeClosed(1, 230005050).toArray();
        long st = System.currentTimeMillis();
        Long result =forkJoinPool.invoke(new SumTask(data,0,data.length-1));
        forkJoinPool.shutdown();
        long st2 = System.currentTimeMillis();
        System.out.println("result "+result+" ct:"+(st2-st)+"ms");
        long total=0;
        for(int i=0;i<data.length;i++){
            total+=data[i];
        }
        long st3 = System.currentTimeMillis();
        System.out.println("total "+total+" ct:"+(st3-st2)+"ms");
    }

    private class SumTask extends RecursiveTask<Long> {
        private long[] data;
        private int from;
        private int to;

        public SumTask (long data[],int from,int to){
            this.data=data;
            this.from=from;
            this.to=to;
        }

        @Override
        protected Long compute() {
            if(to-from<300000){
               long total=0;
               for(int i = from;i<=to;i++){
                   total+=data[i];
               }
               return total;
            }else{
              int mid = (from+to)/2;
              //  System.out.println(from+" - "+to+" m "+mid);
                SumTask left = new SumTask(data,from,mid);
                SumTask right = new SumTask(data,mid+1,to);
                left.fork();
                right.fork();
                return left.join()+right.join();
            }

        }
    }

    @Test
    public void testCale(){

        String  key ="123";
        int ht = hash(key);
        System.out.println(ht);
        int ca = 15 & ht;
        int tr = ht % 16;
        System.out.println("ca:"+ca);
        System.out.println("tr:"+tr);
        int r1 = 235 & 31;
        int r2 = 235 % 32;
        System.out.println("r1:"+r1);
        System.out.println("r2:"+r2);
        System.out.println("r23:"+(1<<10));
        System.out.println("r23:"+(3<<10));
        System.out.println("r32:"+(1024>>10));

        int _r  = 6|14;
        System.out.println(_r);


    }

    public int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }



}
