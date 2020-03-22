package com.basic.sort;

/**
 * 插入排序
 * 第一个默认有序
 * 前面与后面比较，若后面的比前面小，则交换，直到前面没有元素
 *
 * 验证自己写的是否正确可以自制对数器
 *
 */
public class InsertionSort {
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        // i从1开始，因为第一个不用排序
        for (int i = 1;i<arr.length;i++){
            // j-- 满足if条件后，向前交换位置，j后退一步，继续判断大小，直到j=0
            for (int j = i-1;j >= 0;j--){
                if (arr[j]> arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,5,7,1};
        insertionSort(arr);
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]+",");
        }
    }
}
