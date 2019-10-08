package com.zca.Test_Array;

import java.util.Arrays;

/**
 * 测试java.util.Attays工具类的使用
 * @author Altria
 */
public class test_Arrays_01 {
    public static void main(String[] args){
        test_Attays_ToString();
        test_Sort();
        test_BinarySearch();
    }

    /**
     * 将数组中的元素打印出来
     */
    public static void test_Attays_ToString(){
        int[] i = {10, 20, 30};
        System.out.println(Arrays.toString(i));
    }

    /**
     * 将数组排序
     * 如果要将自己定义的类进行排序，需要继承Comparable
     */
    public static void test_Sort(){
        int[] i = {40, 90, 20, 70, 10, 100, 99};
        Arrays.sort(i);
        System.out.println(Arrays.toString(i));
    }

    /**
     * 二分法查找
     */
    public static void test_BinarySearch(){
        int[] i = {40, 90, 80, 20, 70, 10, 100, 99};
        System.out.println(Arrays.binarySearch(i, 20));
    }
}
