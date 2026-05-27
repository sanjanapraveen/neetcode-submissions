class Solution {
    int[][] dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    
                    res= Math.max(res,dfs(i, j, grid) );
                }
            }
        }
        return res;
        
    }
    public int dfs(int i, int j, int[][] grid){
        if(i<0 ||i>grid.length|| j<0||j>grid[0].length||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int area =1;
        for(int[]d:dir){
            int r=i+d[0];
            int c= j+d[1];
            if(r>=0 && r< grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                area+=dfs(r,c,grid);
            }
        }
        return area;

    }
}
