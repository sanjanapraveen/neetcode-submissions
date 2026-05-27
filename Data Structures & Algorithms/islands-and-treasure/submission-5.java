class Solution {
    Queue<int[]> q= new LinkedList<>();
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void islandsAndTreasure(int[][] grid) {


        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        
        int n=0;
        while(!q.isEmpty()){
            n++;
            int s=q.size();
            for(int i=0;i<s;i++){
                int[] p =q.poll();
                for(int[] d: dir){
                    int r = p[0]+d[0];
                    int c = p[1]+d[1];
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]>n ){
                        grid[r][c]=n;
                        q.add(new int[]{r,c});
                    }

                }
            }

        }

        
    }
}
