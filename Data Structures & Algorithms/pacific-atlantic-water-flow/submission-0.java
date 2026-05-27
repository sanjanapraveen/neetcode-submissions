class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       boolean[][] pac= new boolean[heights.length][heights[0].length];
       boolean[][] atl= new boolean[heights.length][heights[0].length];


       for(int i=0;i< heights.length;i++){
        for(int j=0;j< heights[0].length;j++){
            if(i==0 || j==0){
                pac[i][j]=true;
            }
            if(i==heights.length-1 || j==heights[0].length-1){
                atl[i][j]=true;
            }
        }}

    for(int i=0;i< heights.length;i++){
        for(int j=0;j< heights[0].length;j++){
            if(pac[i][j]==true){
                dfs(i,j,pac,heights);
            }
            if(atl[i][j]==true){
                dfs(i,j,atl,heights);
            }
        }
       }
       List<List<Integer>> res = new ArrayList<>();
    for(int i=0;i< heights.length;i++){
        for(int j=0;j< heights[0].length;j++){
            if(pac[i][j]==true && atl[i][j]==true){
                List<Integer> l= new ArrayList<>();
                l.add(i);
                l.add(j);
                res.add(l);
            }
        }
       }
return res;
    }
    
    
    
    
        public void dfs (int i, int j, boolean[][] ocean,int[][] heights ){
        for(int[] d :dir){
            int r = i+d[0];
            int c = j+d[1];
            if(r>=0 && r< heights.length && c>=0 && c< heights[0].length && heights[r][c]>=heights[i][j] && ocean[r][c]==false){
                    ocean[r][c]=true;
                    dfs(r,c,ocean,heights);
            }
        }

    }
}
