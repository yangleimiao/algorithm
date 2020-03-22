package com.basic.sort;

/**
 * 选择排序
 * 第一个元素为有序，从剩余的数挑最小的与第一个交换，以此类推
 */
public class SelectionSort {
    public void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0;i < arr.length - 1;i++){
            int minIndex = i;
            //每遍历一次找出数组剩余数中最小的一个，记录其下标，与第i个交换
            for (int j = i+1;j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,minIndex,i);
        }
    }

    public void swap(int[] arr,int i,int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
