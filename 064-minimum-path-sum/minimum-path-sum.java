# -*- coding:utf-8 -*-


# Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
#
# Note: You can only move either down or right at any point in time.


public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i < n-1+m;i++){
            int y = Math.min(i,m-1);
            int x = i - y;
            for(;y > -1 && x < n;y--,x++){
                int add = 0;
                if(x-1 >= 0){
                    add = grid[x-1][y];
                    if(y-1 >= 0){
                        add = Math.min(add,grid[x][y-1]);
                    }
                }else{
                    if(y-1 >= 0){
                        add = grid[x][y-1];
                    }
                }
                grid[x][y] += add;
            }
        }
        return grid[n-1][m-1];
    }
}
