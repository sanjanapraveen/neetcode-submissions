class Solution {
        boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return dfs(i,j, grid);
                }
            }
        }
        
        return 0;
    }

    public int dfs(int i, int j, int[][]grid){

                if(i<0 || j<0|| j>=grid[0].length||i>=grid.length || grid[i][j]==0){
            return 1; //count that as parameter
        }
        if(visited[i][j]){
            return 0;
        }

        visited[i][j]=true;
        return dfs(i+1,j,grid)+dfs(i-1,j,grid)+dfs(i,j+1,grid)+dfs(i,j-1,grid);

    }
}