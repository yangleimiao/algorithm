package com.basic.sort;

/**
 * 桶排序
 * 计数排序
 * 按照数组中数的取值范围分桶，如，数的范围0~100，则分101个桶（容器），
 * 遍历数组，数为N则N号桶计数器++（设置一个计数变量），
 * 最后输出时，0号桶计数器为几，就输出几个0，以此类推
 */
public class BucketSort {
    public void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            // 系统方法，取两数之间较大的那个 return (a > b) ? a : b
            max = Math.max(max, i);
        }
        // 数组没有负数的情况
        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }
        // 输出
        // 记录arr的下标
        int j = 0;
        for(int i = 0;i<bucket.length;i++){
            while (bucket[i]-- > 0){
                arr[j++] = j;
            }
        }
    }
}
