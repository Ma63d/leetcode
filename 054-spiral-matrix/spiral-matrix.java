# -*- coding:utf-8 -*-


# Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
#
#
#
# For example,
# Given the following matrix:
#
#
# [
#  [ 1, 2, 3 ],
#  [ 4, 5, 6 ],
#  [ 7, 8, 9 ]
# ]
#
#
# You should return [1,2,3,6,9,8,7,4,5].


public class Solution {
    List<Integer> ret = new ArrayList<Integer>();
    public List<Integer> spiralOrder(int[][] matrix) {
        this.ret = new ArrayList<Integer>();
        if(matrix.length < 1) return this.ret;
        int ylen = matrix[0].length;
        int xlen = matrix.length;
        int len = Math.min(xlen,ylen);
        for(int i = 0;i <= (len-1)/2;i++){
            _spiralReadOneTime(matrix,i);
        }
        return this.ret;
    }
    public void _spiralReadOneTime(int[][] matrix,int pos){
        int ylen = matrix[0].length;
        int xlen = matrix.length;
        if(pos == xlen/2){
            for(int i = pos;i < ylen-pos;i++)
                this.ret.add(matrix[pos][i]);
        }else if(pos == ylen/2){
            for(int i = pos;i < xlen-pos;i++)
                this.ret.add(matrix[i][pos]);
        }else{
            for(int i = pos;i < ylen-pos-1;i++){
                this.ret.add(matrix[pos][i]);
            }
            for(int i = pos;i < xlen-pos-1;i++){
                this.ret.add(matrix[i][ylen-1-pos]);
            }
            for(int i = pos;i < ylen-pos-1;i++){
                this.ret.add(matrix[xlen-1-pos][ylen-1-i]);
            }
            for(int i = pos;i < xlen-pos-1;i++){
                this.ret.add(matrix[xlen-1-i][pos]);
            }
        }
        
    }
}
