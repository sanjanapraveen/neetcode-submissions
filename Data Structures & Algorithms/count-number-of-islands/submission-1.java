class Solution {
    int[][] dir= new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        
        int res=0;

        for(int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j,char[][] grid) {
        if(i<0||i>grid.length|| j<0||j>grid[0].length|| grid[i][j]=='0'){
            return;
        }
        grid[i][j] ='0' ;//mark as visited
        

        for(int []d: dir){
            int r = i+d[0];
            int c = j+d[1];
            if(r>=0 && r<grid.length && c>=0 &&c<grid[0].length && grid[r][c]=='1'){

                dfs(r,c,grid); 
            }
        }
        return;
    }
}
