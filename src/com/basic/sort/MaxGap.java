package com.basic.sort;

/**
 * 一个无序的数组，求 假如排序后 相邻两个数之间最大的差值，
 * 限制条件，时间复杂度：O(n)
 * 建立桶，以数的个数建立桶，N个数建立N+1个桶
 * 将数的范围等分成桶的个数N+1
 * 创建boolean数组，长度为桶的个数，数组中每个数表示本桶里是否有数
 * 创建int数组，maxs，mins，数组中每个数分别表示本桶里最大值和最小值
 * 这样做的好处是，不需要记录所有分到这个桶里的所有数，只需要记录最大值最小值
 *
 * 因为按照数的取值范围分了N+1个数，所有左右两头的桶里必有数，中间必有空桶
 * 空桶左边桶的最大值与右边桶的最小值在排序之后必相邻
 * 空桶右边桶的min - 空桶左边桶的max 大于等于 一个桶的范围
 * 单个桶内最大值 - 最小值 小于 一个桶的范围
 *
 * 所以最后比较的是空桶两侧的最小值与最大值之差，以及 相邻两个桶的最小值最大值之差
 *
 */
public class MaxGap {
    public int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // 取出数组中数的取值范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for (int v : arr) {
            max = Math.max(v, max);
            min = Math.min(v, min);
        }
        // 表示数组中数都是同一个数
        if (min == max) {
            return 0;
        }
        // boolean[] 初始值为false
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        // 桶号
        int bid;
        // 数放入桶内，并找到每个桶内的最大值最小值
        for (int i = 0; i < len; i++) {

            bid = bucket(arr[i], max, min, len);
            // 如果这个桶里已有数，那需要之前的数与新加的数比较大小
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
            // 填入数后改为true，表示这个桶里有数
            hasNum[bid] = true;
        }
        int res = 0;
        // 上一个桶里最大的数，初始化为0号桶的最大值
        int lastMax = maxs[0];
        for (int i = 1; i < len; i++) {
            // 如果这个桶里有数
            if (hasNum[i]) {
                // 上一个最大值res 与 本桶的最小值与上一个桶的最大值做差 相比
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    // 决定这个数分到几号桶里，从0号开始，所以不是len+1
    public int bucket(int num, int max, int min, int len) {
        return ((num - min) * len / (max - min));
    }
}
