class Solution {
int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {

        for(int i=0;i<board.length;i++){
          for(int j=0;j<board[0].length;j++)  {
            if(i==0 || i==board.length-1 ||j==0|| j==board[0].length-1){
                if(board[i][j]=='O'){
                    dfs(i,j,board);
                }
            }
          }
        }

        for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++) {
            if(board[i][j] == 'T'){
                board[i][j] ='O'; //mark them as surrounded
            }else{
                board[i][j] ='X';
            }
           }
        }
        
    }
    public void dfs(int i, int j, char[][] board){
        if(i<0 ||i>board.length ||j<0||j>board[0].length|| board[i][j]=='X'){
            return;
        }

        board[i][j]='T';
        for(int[]d :dir){
            int r = d[0]+i;
            int c = d[1]+j;
            if(r>=1 && r<board.length-1 && c>=1 && c<board[0].length-1 && board[r][c]=='O'){
                dfs(r,c,board);
        }
        }
        return;

    }
}
