# -*- coding:utf-8 -*-


# A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
#
# The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
#
# How many possible unique paths are there?
#
#
#
# Above is a 3 x 7 grid. How many possible unique paths are there?
#
#
# Note: m and n will be at most 100.


public class Solution {
    public int uniquePaths(int m, int n) {
        if(n == 1|| m== 1) return 1;
        int x = m-1,y = n-1;
        double topResult = 1;
        double bottomResult = 1;
        for(int i = x+1;i < x+y+1;i++) topResult*=i;
        for(int i = 2;i < n;i++) bottomResult*=i;
        return (int)(topResult/bottomResult);
    }
}
