package com.zca.sort;

/**
 * 二分法查找（折半检索）
 * 二分法查找的前提条件：检索的数组必须是从高到底排好序的
 * @author Altria
 */
public class test_Binary_Search {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        System.out.println(myBinary_Search(arr, 10));
    }

    public static int myBinary_Search(int[] arr, int value){
        int low = 0;
        int high = arr.length -1;
        while(low <= high){
            int mid = (low + high)/2;

            if(value == arr[mid]){
                return mid;
            }
            if(value > arr[mid]){
                low = mid + 1;
            }

            if(value < arr[mid]){
                high = mid -1;
            }
        }
        return -1;

    }
}
