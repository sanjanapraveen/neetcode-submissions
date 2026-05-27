class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q= new LinkedList<>();
        int fresh=0;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0;i< grid.length;i++){
          for(int j=0;j< grid[0].length;j++){
            if(grid[i][j]==2){
                q.add(new int[]{i,j});
            }
            if(grid[i][j]==1){
                fresh++;
            }
          }  
        }
        int time=0;
        while(!q.isEmpty()&& fresh>0){
            int s = q.size();
            for(int i=0;i<s;i++){
                int[] e = q.poll();
                for(int[] d:dir){
                    int r = d[0]+e[0];
                    int c = d[1]+e[1];

                    if(r<0 ||c<0|| r>=grid.length||c>=grid[0].length|| grid[r][c]==0){
                        continue;
                    }
                    if(grid[r][c]==1){

                        grid[r][c]=2;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }
            }
            time++;

        }
        return fresh==0?time:-1;
    }
}
