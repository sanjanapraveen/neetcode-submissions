class Solution {
        int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {

        for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
            if((i==0 || i==board.length-1 || j==0 || j==board[0].length-1 )&& board[i][j]=='O'){
                dfs(i,j,board);
            }
           } 
        }
        for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
            if(board[i][j]=='T'){
                board[i][j]='O';
            }else{
                board[i][j]='X';
            } 
        } 
    }
    }

    public void dfs(int i, int j,char[][] board) {
        board[i][j]='T';
        for(int[] d: dir){
           int r = i+d[0];
           int c = j+d[1];
           if(r>=0 && r<board.length && c>=0 && c<board[0].length && board[r][c]=='O'){
            dfs(r,c,board);
           }

        }

    }
}
