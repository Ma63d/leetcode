# -*- coding:utf-8 -*-


# Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
#
#
# For example,
# Given n = 3,
#
# You should return the following matrix:
#
# [
#  [ 1, 2, 3 ],
#  [ 8, 9, 4 ],
#  [ 7, 6, 5 ]
# ]


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int result = 1;
        for(int i = 0;i < n;i++){
            result = fill(matrix,i,result);
        }
        return matrix;
    }
    public int fill(int[][] matrix,int i,int start){
        int n = matrix.length;
        if(n%2 == 1 && i == n/2){
            matrix[i][i] = start;
            return start+1;
        }
        for(int j = i;j < n-i-1;j++){
            matrix[i][j] = start;
            start++;
        }
        for(int j = i;j < n-i-1;j++){
            matrix[j][n-i-1] = start;
            start++;
        }
        for(int j = n-i-1;j > i;j--){
            matrix[n-1-i][j] = start;
            start++;
        }
        for(int j = n-i-1;j > i;j--){
            matrix[j][i] = start;
            start++;
        }
        return start;
    }
}
