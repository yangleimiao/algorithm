package com.basic.sort;

/**
 * 归并排序
 * 递归过程：
 * 从外层到内层是压栈，内层条件满足后向上层返回，每向上一层，都会执行合并，创建一个临时的help数组
 */
public class MergeSort {
    public void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }
    public void mergeSort(int[] arr,int l,int r){
        int middle = l+(r-l)/2;
        mergeSort(arr,l,middle);
        mergeSort(arr,middle+1,r);

    }
    public void merge(int[] arr,int l,int mid, int r){
        // 创建一个长度为当前需要排序的个数的数组
        int[] help = new int[r - l +1];
        // 设置范围，比较大小依次拷贝到help数组
        // i是help数组的下标
        int i = 0;
        // p1是已排好序的左边第一个数据
        int p1 = l;
        // p2是内层排好序，返回到上层后到右半部分的第一个元素
        int p2 = mid + 1;
        // 限制条件  2 5 | 4 7 8
        while (p1 <= mid && p2 <= r){
            if (arr[p1] <= arr[p2]){
                help[i] = arr[p1];
                p1++;
            }else {
                // arr[p1] > arr[p2]
                help[i] = arr[p2];
                p2++;
            }
            i++;
            // 上述简单写成以下，判断arr[p1] arr[p2]大小，先拷贝，再++
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 像上述例子，最后的两个元素无法拷贝的help，因为左侧已经全部拷完，p1再向右移就越界了，所以添加以下条件
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        // 最后将排好序的数组拷贝会以前的arr
        for (i = 0;i<arr.length;i++){
            // l+i 此时的数组不一定是从0开始
            arr[l+i] = help[i];
        }
    }

}
