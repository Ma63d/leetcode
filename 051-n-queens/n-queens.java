# -*- coding:utf-8 -*-


# The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
#
#
#
# Given an integer n, return all distinct solutions to the n-queens puzzle.
#
# Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
#
# For example,
# There exist two distinct solutions to the 4-queens puzzle:
#
# [
#  [".Q..",  // Solution 1
#   "...Q",
#   "Q...",
#   "..Q."],
#
#  ["..Q.",  // Solution 2
#   "Q...",
#   "...Q",
#   ".Q.."]
# ]


public class Solution {
    ArrayList<List<String>> ret = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        this.ret = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++)
            Arrays.fill(board[i],'.');
        _solve(board,0,n);
        return this.ret;
    }
    public void _solve(char[][] board, int pos,int n){
        if(pos == n){
            ArrayList<String> result = new ArrayList<String>();
            for(int i = 0;i < n;i++){
                result.add(new String(board[i]));
            }
            this.ret.add(result);
            return;
        }
        for(int i = 0;i < n;i++){
            board[pos][i] = 'Q';
            if(_checkPos(board,pos,i,n)) _solve(board,pos+1,n);
            board[pos][i] = '.';
        }
    }
    public boolean _checkPos(char[][]board,int x,int y,int n){
        if(x == 0) return true;
        for(int i = 0;i < x;i++){
            if(board[i][y] == 'Q') return false;
        }
        for(int i = 0;i < n;i++){
            if(i != y && board[x][i] == 'Q') return false;
        }
        int left = y-1,right = y+1;
        x--;
        while(left >= 0 || right < n){
            if(x < 0) return true;
            if((left >= 0 && board[x][left] == 'Q') || (right < n && board[x][right] == 'Q')) return false;
            x--;left--;right++;
        }
        return true;
    }
}
