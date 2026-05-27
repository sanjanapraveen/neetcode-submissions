class Solution {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int f=0;

        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    f++;
                }
            }
        }
        int n=0;
        while(!q.isEmpty() && f!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                int[] e = q.poll();
                for(int[] d : dir){
                    int r = e[0]+d[0];
                    int c = e[1]+d[1];

                    if(r>=0 && r< grid.length && c>=0 && c< grid[0].length && grid[r][c]==1){
                        grid[r][c]=2;
                       q.add(new int[]{r,c});
                        f--;
                    }

                }
            }
            n++;

        }
        if(f==0){
            return n;
        }
        return -1;
        
    }
}
