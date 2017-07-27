public class Solution {
    // public void solveSudoku(char[][] board) {
    //     _solvesSudoku(board,0);
    // }
    // private boolean _solvesSudoku(char[][] board , int start){
    //     if(start == 81){
    //         return true;
    //     }
    //     int i = start/9,j = start - i * 9;
    //     if(board[i][j] == '.'){
    //         for(int k = 0;k < 9;k++){
    //             char test = (char)('1' + k);
    //             if(_checkPosition(board,start,test)){
    //                 board[i][j] = test;
    //                 if(_solvesSudoku(board,start+1)){
    //                     return true;
    //                 };
    //             }
    //         }
    //         board[i][j] = '.';
    //         return false;
    //     }else{
    //         return _solvesSudoku(board,start+1);
    //     }
    // }
    // private boolean _checkPosition(char[][] board , int position,char target){
    //     int i = position/9,j = position - i * 9;
    //     int m = i/3*3,n = j/3*3;
    //     for(int k = 0;k < 9;k++){
    //         int x = m + k/3,y = n + k%3;
    //         if(board[k][j] == target || board[i][k] == target || board[x][y] == target){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    public void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    public boolean dfs(char[][] board,int pos){
        if(pos == 81){
            return true;
        }
        int x = pos / 9;
        int y = pos % 9;
        if(board[x][y] == '.'){
            for(int i = 1;i < 10;i++){
                if(check(board,pos,(char)('0' + i),x,y)){
                    board[x][y] = (char)('0' + i);
                    if(dfs(board,pos+1)) return true;
                    board[x][y] = '.';
                }
            }
            return false;
        }
        return dfs(board,pos+1);
    }
    public boolean check (char[][] board,int pos,char c,int x,int y) {
        int p = x /3, q = y /3;
        for(int i = 0;i < 9;i++){
            int a = p*3 + i/3, b= q*3 +i%3;
            if(board[(x+i)%9][y] == c || board[x][(y+i)%9] == c || board[a][b] ==c) return false;
        }
        return true;
    }
}