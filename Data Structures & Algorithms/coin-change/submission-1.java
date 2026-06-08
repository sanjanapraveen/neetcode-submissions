class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[][] dp = new int[n][amount+1];
        if(amount==0){
            return 0;
        }
        for (int[] row: dp)
            Arrays.fill(row, amount+1);

        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<amount+1;j++){
                if(i>=1 && j-coins[i]>=0){
                    dp[i][j] = Math.min(dp[i][j-coins[i]]+1,dp[i-1][j]);
                }else{
                    if(i==0){
                        if(j%coins[i]==0){
dp[i][j]= j/coins[i];
                        }
                        
                    }else if(j-coins[i]<0){
                        dp[i][j]= dp[i-1][j];
                    }
                }
            }
        }
        return dp[n-1][amount]>amount?-1:dp[n-1][amount];
        
    }
}
