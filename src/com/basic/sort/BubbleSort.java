package com.basic.sort;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 取第一个元素依次向后比较，若比后面大，则交换位置，比后面小，就停止交换
 * 对数器 ：写一个简单不易出错的方法，同时对同样的数组排序，以此判断算法是否正确
 */
public class BubbleSort {
    public static void bubbleSoft(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for(int i = arr.length - 1;i>0;i--){
            for (int j = 0;j<i;j++){
                swap(arr,i,i+1);
            }
        }
    }
    // 交换位置
    public static void swap(int[] arr,int l,int r){
        int i;
        i = arr[l];
        arr[l] = arr[r];
        arr[r] = i;
        // 另一种交换方式
        //arr[l] = arr[l] ^ arr[r];
        //arr[r] = arr[l] ^ arr[r];
        //arr[l] = arr[l] ^ arr[r];
    }

    // 生成随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
    // 复制数组 ：两个方法对相同的两个数组进行排序
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 判断排序后的两个数组是否一致
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // 输出数组
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 对照组
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int testTime = 10;  // 测试次数
        int maxSize = 10;   // 生成的数组大小
        int maxValue = 20;  // 生成的最大的值
        boolean success = true;    // 判断是否一致

        for (int i = 0;i < testTime;i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSoft(arr1);
            comparator(arr2);

            // 判断排序之后的两个数组是否一致
            if (!isEqual(arr1,arr2)){
                success = false;
                printArray(arr1);
                break;
            }
        }
        System.out.println(success);
    }

}
