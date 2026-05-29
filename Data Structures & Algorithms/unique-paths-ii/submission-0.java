class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] dp= new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        dp[obstacleGrid.length-1][obstacleGrid[0].length-1]=1;

        for(int i=obstacleGrid.length-2;i>=0;i--){
            if(obstacleGrid[i][obstacleGrid[0].length-1]!=1 ){
                dp[i][obstacleGrid[0].length-1]=dp[i+1][obstacleGrid[0].length-1];
            }
        }
        for(int j=obstacleGrid[0].length-2;j>=0;j--){
            if(obstacleGrid[obstacleGrid.length-1][j]!=1){
                dp[obstacleGrid.length-1][j]=dp[obstacleGrid.length-1][j+1];
            }
        }

        for(int i=obstacleGrid.length-2;i>=0;i--){
            for(int j=obstacleGrid[0].length-2;j>=0;j--){
                if(obstacleGrid[i][j]!=1){
                    if(obstacleGrid[i+1][j]!=1){
                        dp[i][j]+=dp[i+1][j];
                    }
                    if(obstacleGrid[i][j+1]!=1){
                        dp[i][j]+=dp[i][j+1];
                    }
                }
            }
        }
        return dp[0][0];

        
    }
}