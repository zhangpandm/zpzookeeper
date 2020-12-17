package com.zp.lr.service.suanfa.sort;


import org.junit.Test;

import java.util.Arrays;

/**
 * @Auther: zhangpanm
 * @Date: 2020/6/23
 * @Description:归并排序
 */
public class MegerSort {

    @Test
    public void testInserSort(){
        int[] a ={3,6,90,23,64,2,23,6,8,5};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testmegerReduceSort(){
        int[] a ={3,6,90,23,64,2,23,886,-98};
        megerReduceSort(a);
        System.out.println(Arrays.toString(a));

    }
    /**
     * 插入排序
     * @param data
     */
    public static void insertSort(int [] data){
        int n =data.length;
        if(n>0){
            for(int i=1;i<n;i++){//从下标1（第二）个开始排序，第一个不用排序，可以认为0~i的区域是已经从小到大已经排好了序
                int d = data[i];
                int j=i-1;
                for(;j>=0;j--){//在已经排好序的区间里，从最高的尾向前查找
                    if(data[j]>d){
                        data[j+1]=data[j];//数据后移
                    }else{//前面的更小，跳出内层循环
                        break;
                    }
                }
                data[j+1]=d;
               // System.out.println("第"+i+":"+Arrays.toString(data));
            }
        }
    }

    /**
     * 归并排序
     * @param data
     */
    public static void megerReduceSort(int [] data){
        megerReduceSort(data,0,data.length-1);
    }

    /**
     * 递归中分及合并
     * @param data
     * @param left 左指针
     * @param right 右指针
     */
    private static void megerReduceSort(int [] data,int left,int right){
        if(left<right){//当分隔到left=right即小区域只有个数据时停止拆分
            int mid = (left+right)/2;//中间分隔点
            megerReduceSort(data,left,mid);//左区域继续拆分
            megerReduceSort(data,mid+1,right);//右区域继续拆分
            megerData(data,left,mid,right);//合并数据
        }

    }

    /**
     *  合并数据
     * @param data
     * @param left 左指针
     * @param mid  中间指针
     * @param right 右指针
     */
    private static void megerData(int[] data,int left,int mid,int right){
        int temp [] = new int[data.length];//临时数组用于存储数据
        int lpoint = left; //左区域开头指针点
        int rpoint = mid+1;//右区域开头指针点
        int cpoint = left;//当前临时数组指针点

        while (lpoint<=mid&&rpoint<=right){
            if(data[lpoint]<data[rpoint]){
                temp[cpoint] = data[lpoint];//左区域小的放入临时数组
                lpoint++;//左区域后移
                cpoint++;//当前指针移动
            }else {
                temp[cpoint]=data[rpoint];//右区域小的放入临时数组
                rpoint++;//右区域指针后移
                cpoint++;//当前指针移动
            }
        }

        while (lpoint<=mid){//将左区域没有移动到临时数组数据移动至临时数组
            temp[cpoint++]=data[lpoint++];
        }
        while (rpoint<=right){//将右区域没有移动到临时数组数据移动至临时数组
            temp[cpoint++]=data[rpoint++];
        }
        for(int i = left;i<=right;i++){//将排好序的临时数组拷贝的data数组中
            data[i]=temp[i];
        }
    }


}
