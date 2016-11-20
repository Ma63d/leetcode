# -*- coding:utf-8 -*-


# Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
#
# The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
#
#
#
# A partially filled sudoku which is valid.
#
#
# Note:
# A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board[0].length;
        for(int i = 0;i < len;i++){
            boolean[] appear = new boolean[10];
            for(int j = 0;j < len;j++){
                if(board[i][j] == '.') continue;
                if(appear[board[i][j]-'0'] != false) return false;
                appear[board[i][j]-'0'] = true;
            }
        }
        for(int i = 0;i < len;i++){
            boolean[] appear = new boolean[10];
            for(int j = 0;j < len;j++){
                if(board[j][i] == '.') continue;
                if(appear[board[j][i]-'0'] != false) return false;
                appear[board[j][i]-'0'] = true;
            }
        }
        for(int i = 0;i < len;i+= 3){
            for(int j = 0;j < len;j+=3){
                boolean[] appear = new boolean[10];
                for(int p = i;p < i + 3;p++){
                    for(int q = j;q < j + 3;q++){
                        if(board[p][q] == '.') continue;
                        if(appear[board[p][q]-'0'] != false) return false;
                        appear[board[p][q]-'0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
