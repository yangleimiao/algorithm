package com.basic.structure;

/**
 * 之字形打印矩阵
 * 从左上角开始，对角线打印
 */
public class ZigZagPrintMatrix {





    public static void printLevel(int[][] matrix,int row1,int row2,int col1,int col2,boolean fromUp){
        if (fromUp){ // 为true时表示斜向下输出
            // row1 <= row2 不能越过下边界
            while (row1 != row2+1){
                System.out.print(matrix[row1++][col1--]+" ");
            }
        }else { // 为false，表示斜向上输出
            while (row2 != row1-1){
                System.out.println(matrix[row2--][col2++]+" ");
            }
        }
    }
}
