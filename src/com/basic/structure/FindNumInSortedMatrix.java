package com.basic.structure;

/**
 * 排好序的矩阵中判断是否有某个数
 * 矩阵的顺序，每一行（从左向右）每一列（从上到下）都是由小到大排序
 * 要求时间复杂度O(N+M)，空间复杂度O(1)
 * 从右上角或左下角开始比较
 */
public class FindNumInSortedMatrix {
    public static boolean isContains(int[][] matrix, int num) {
        // 右上角
        int row = 0;
        int col = matrix[0].length - 1;
        // 限制越界条件
        while (row < matrix.length && col > -1) {
            // 当前数等于num
            if (matrix[row][col] == num) {
                return true;
            } else if (matrix[row][col] > num) {
                // 从右上角开始，若当前数大于num，排除当前列，向前一列移动
                col--;
            } else {
                // 若当前数小于num，向下一行找
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }
}
