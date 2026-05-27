class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();
        int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i=0;i< grid.length;i++){
          for(int j=0;j< grid[0].length;j++){
            if(grid[i][j]==0){
                q.add(new int[]{i,j});
            }
          }  
        }
        int step=1;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                int[] e = q.poll();
                for(int[] d: DIR){
                    int r = d[0]+e[0];
                    int c = d[1]+e[1];
                    if(r<0 ||c<0|| r >= grid.length||c >=grid[0].length || grid[r][c]==-1){
                        continue;
                    }
                    if(grid[r][c]==Integer.MAX_VALUE){
                        grid[r][c]=step;
                        q.add(new int[]{r,c});
                    }
                }
            }
            step++;
        }
        
    }
}
