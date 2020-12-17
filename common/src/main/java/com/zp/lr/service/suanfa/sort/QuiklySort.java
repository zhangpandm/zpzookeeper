package com.zp.lr.service.suanfa.sort;

import org.junit.Test;

import javax.xml.parsers.SAXParser;
import java.util.Arrays;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/22
 * @Description:快速排序
 *
 */
public class QuiklySort {


    @Test
    public void testE(){
        int [] data={73,85,10,231,11,23,67,101};
        int [] data2={12,73,85,10,21,141,23,67,103,7,94,85,21,85};
        int [] data3={3,6,1,1,6};
        quikSort(data);
        System.out.println(Arrays.toString(data));
    }
    public static void quikSort(int[] data){
        quikSort(data,0,data.length-1);
    }

    public static void quikSort(int[] data,int left,int right){
        int base = data[left];//基准数
        int leftPoint= left;
        int rightPoint = right;
        while (leftPoint<rightPoint){//左下标小于右下标是开始查找排序,while保证可以查到可以划分区域的程度{67,23,10,11} 73 {231,85,101}
            //循环查找右边的数直至找到小于基准数数为
            while (leftPoint<rightPoint&&data[rightPoint]>=base){//data[rightPoint]>=base一定要大于等于即跳过相等数，否则数据里重复的数据会死循环
                rightPoint--;
            }
            if(leftPoint<rightPoint){//找到右边小于基准数了，开始交互位置
                int temp = data[rightPoint];
                data[rightPoint] = base;
                data[leftPoint]=temp;
            }
            //循环查找左边的数直至找到大于于基准数数为止
            while (leftPoint<rightPoint&&data[leftPoint]<=base){
                leftPoint++;
            }
            if(leftPoint<rightPoint){//找到右边小于基准数了，开始交互位置
                int temp = data[leftPoint];
                data[leftPoint] = base;
                data[rightPoint]=temp;
            }

        }
        //开始递归
        if(left<rightPoint)
         quikSort(data,left,leftPoint-1);//左区域
        if(leftPoint<right)
        quikSort(data,rightPoint+1,right);//右区域
    }

}
