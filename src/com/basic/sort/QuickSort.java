package com.basic.sort;

/**
 * 快速排序
 * 经典快速排序：取要排序的数组最后一个数为划分值，其他数与它比较，小于等于它的放小于等于区，大于它的放大于区
 * 随机快速排序：随机取数组中的一个数（A）与数组最后一个交换位置作为划分值，其他数与它（A）比较，小于它的放小于区，大于它的放大于区，等于的放中间
 * 如果其他数小于A，则这个数与小于区的下一个位置交换，然后小于区向右扩一个位置；如果这个数大于A，这个数与大于区的前一个数交换
 *
 * 大于区初始化为最后一个数
 */


public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }
    public static void quickSort(int[] arr,int L,int R){
        if(L<R){
            // 随机选一个数，与最后一个交换，作为划分值
            swap(arr,L + (int) (Math.random() * (R - L + 1)),R);
            int[] index = partition(arr, L,R);
            quickSort(index,L,index[0]+1);
            quickSort(index,index[1]+1,R);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int[] partition(int[] arr,int L,int R){
        // 小于区的边界
        int less = L - 1;
        // 大于区的边界
        int more = R;
        while (L < more){
            if (arr[L] < arr[R]){
                // 如果当前位置的数小于划分值，则当前位置(L)的数与小于区的下一位数交换（less+1）,当前位置再向前（L+1）
                swap(arr,++less,L++);
            }else if (arr[L] > arr[R]){
                // 如果当前位置的数大于划分值，则当前位置的数与大于区的前一位数交换（more-1：大于区扩了一个位置），
                // 当前数还是L位置，是新换过来的数，继续与划分值比较
                // 因为less没变，所以小于区还在原来的位置
                swap(arr,--more,L);
            }else {
                // 如果当前位置的数等于划分值，则继续，不操作
                L++;
            }
        }
        // 开始时将划分值分到大于区，比较完之后与more位置交换，换到等于区
        swap(arr,more,R);
        // 返回的是等于区域的下标的开始和结束
        return new int[] { less + 1, more };
    }
}
