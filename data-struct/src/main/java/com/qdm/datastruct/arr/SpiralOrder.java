package com.qdm.datastruct.arr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 */
public class SpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{3}, {2}};
//        spiralOrder1(matrix);


        List<Integer> integers = spiralOrder2(matrix);
        System.out.println("integers = " + Arrays.toString(integers.toArray()));

    }



    private static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> orderList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return orderList;
        }

        int top = 0, left = 0, right = matrix[0].length - 1, down = matrix.length - 1;

        while (top <= down && left <= right) {
            for (int i = left; i<= right; i++ ) {
                orderList.add(matrix[top][i]);
            }

            for (int i = top + 1; i<= down; i++ ) {
                orderList.add(matrix[i][right]);
            }

            if(left < right && top < down) {
                for (int i = right - 1; i>= left + 1 ; i-- ) {
                    orderList.add(matrix[down][i]);
                }

                for (int i = down ; i>= top + 1; i-- ) {
                    orderList.add(matrix[i][left]);
                }
            }

            top++;
            left++;
            right--;
            down--;
        }


        return orderList;
    }




    public static List<Integer> spiralOrder1(int[][] matrix) {

        int DIRECT_RIGHT = 0;
        int DIRECT_DOWN = 1;
        int DIRECT_LEFT = 2;
        int DIRECT_TOP = 3;

        int M = matrix.length;
        int N = matrix[0].length;

        int CUR_DIRECT = DIRECT_RIGHT;

        List<Integer> resList = new ArrayList();

        int i = 0;
        int j = 0;

        int RIGHT_LEFT_NAX = N - 1;
        int TOP_DOWN_NAX = M - 1;
        int CUR_LR_STEP = 0;
        int CUR_TOP_DOWN = 0;
        while( resList.size() < M * N ) {

            resList.add(matrix[i][j]);
            if( CUR_DIRECT == DIRECT_RIGHT ) {
                if(CUR_LR_STEP == RIGHT_LEFT_NAX) {
                    CUR_LR_STEP = 0;
                    CUR_TOP_DOWN = 0;
                    CUR_DIRECT = DIRECT_DOWN;
                    i++;
                    TOP_DOWN_NAX--;
                } else {
                    CUR_LR_STEP++;
                    j++;
                }
            } else if( CUR_DIRECT == DIRECT_DOWN ) {
                if(CUR_TOP_DOWN == TOP_DOWN_NAX) {
                    CUR_LR_STEP = 0;
                    CUR_TOP_DOWN = 0;
                    CUR_DIRECT = DIRECT_LEFT;
                    j--;
                    RIGHT_LEFT_NAX--;
                } else {
                    i++;
                    CUR_TOP_DOWN++;
                }
            } else if( CUR_DIRECT == DIRECT_LEFT ) {
                if(CUR_LR_STEP == RIGHT_LEFT_NAX) {
                    CUR_LR_STEP = 0;
                    CUR_TOP_DOWN = 0;
                    CUR_DIRECT = DIRECT_TOP;
                    i--;
                    TOP_DOWN_NAX--;
                } else {
                    j--;
                    CUR_LR_STEP++;
                }
            } else if( CUR_DIRECT == DIRECT_TOP ) {
                if(CUR_TOP_DOWN ==  TOP_DOWN_NAX) {
                    CUR_LR_STEP = 0;
                    CUR_TOP_DOWN = 0;
                    CUR_DIRECT = DIRECT_RIGHT;
                    j++;
                    RIGHT_LEFT_NAX--;
                } else {
                    i--;
                    CUR_TOP_DOWN++;
                }
            }



        }

        return resList;
    }






}
