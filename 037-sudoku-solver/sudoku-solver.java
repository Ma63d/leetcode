# -*- coding:utf-8 -*-


# Write a program to solve a Sudoku puzzle by filling the empty cells.
#
# Empty cells are indicated by the character '.'.
#
# You may assume that there will be only one unique solution.
#
#
#
# A sudoku puzzle...
#
#
#
#
# ...and its solution numbers marked in red.


public class Solution {
    public void solveSudoku(char[][] board) {
        _solvesSudoku(board,0);
    }
    private boolean _solvesSudoku(char[][] board , int start){
        if(start == 81){
            return true;
        }
        int i = start/9,j = start - i * 9;
        if(board[i][j] == '.'){
            for(int k = 0;k < 9;k++){
                char test = (char)('1' + k);
                if(_checkPosition(board,start,test)){
                    board[i][j] = test;
                    if(_solvesSudoku(board,start+1)){
                        return true;
                    };
                }
            }
            board[i][j] = '.';
            return false;
        }else{
            return _solvesSudoku(board,start+1);
        }
    }
    private boolean _checkPosition(char[][] board , int position,char target){
        int i = position/9,j = position - i * 9;
        int m = i/3*3,n = j/3*3;
        for(int k = 0;k < 9;k++){
            int x = m + k/3,y = n + k%3;
            if(board[k][j] == target || board[i][k] == target || board[x][y] == target){
                return false;
            }
        }
        return true;
    }
}
