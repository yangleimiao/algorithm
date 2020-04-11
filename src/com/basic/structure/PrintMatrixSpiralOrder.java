package com.basic.structure;

/**
 * 转圈（螺旋）打印矩阵
 * 找到对角线两个点
 * 向内层变换的条件
 * 越界条件
 */
public class PrintMatrixSpiralOrder {
    // 打印一圈后向内缩
    public static void spiralOrderPrint(int[][] matrix) {
        int row1 = 0;
        int col1 = 0;
        // 右下角坐标
        int row2 = matrix.length - 1;
        int col2 = matrix[0].length - 1;
        while (row1 <= row2 && col1 <= col2) {
            // 打印完外圈后向内缩圈
            printEdge(matrix, row1++, row2--, col1++, col2--);
        }

    }


    // 打印边界
    private static void printEdge(int[][] matrix, int row1, int row2, int col1, int col2) {
        // 只有一行
        if (row1 == row2) {
            for (int i = col1; i <= col2; i++) {
                System.out.print(matrix[row1][i] + " ");
            }
        } else if (col1 == col2) {  // 只有一列
            for (int i = row1; i <= row2; i++) {
                System.out.print(matrix[i][col1] + " ");
            }
        } else { // 多行多列
            // 当前行
            int curR = row1;
            // 当前列
            int curC = col1;
            // 打印外圈第一行
            while (curC != col2) {
                System.out.print(matrix[row1][curC] + " ");
                curC++;
            }
            // 打印外圈右边一列
            while (curR != row2) {
                System.out.print(matrix[curR][col2] + " ");
                curR++;
            }

            // 打印外圈下面一行，从右向左
            while (curC != col1) {
                System.out.print(matrix[row2][curC] + " ");
                curC--;
            }
            // 打印左边一列，从下往上
            while (curR != row1) {
                System.out.print(matrix[curR][col1] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);
    }

}
