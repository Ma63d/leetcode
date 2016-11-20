# -*- coding:utf-8 -*-


# You are given an n x n 2D matrix representing an image.
# Rotate the image by 90 degrees (clockwise).
# Follow up:
# Could you do this in-place?


public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        if(n == 1){
            return;
        }
        int iLen = (n%2 == 1)?(n-1)/2-1:(n-1)/2;
        for(int i = 0;i <= iLen;i++){
            for(int j = 0;j <= (n-1)/2;j++){
                int x = i,y = j,temp = 0;
                for(int k = 0;k < 3;k++){
                    if(k == 0) temp = matrix[x][y];
                    matrix[x][y] = matrix[n-1-y][x];
                    int curTemp = x;
                    x = n-1-y;
                    y = curTemp;    
                    if(k == 2) matrix[x][y] = temp;
                }
            }
            
        }
    }
}
