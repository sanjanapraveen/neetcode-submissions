class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int[] dp = new int[amount+1];
        if(amount==0){
            return 0;
        }

            Arrays.fill(dp, amount+1);

        
            dp[0]=0;
        

        for(int i=0;i<n;i++){
            for(int j=1;j<amount+1;j++){
                if(i>=1 && j-coins[i]>=0){
                    dp[j] = Math.min(dp[j-coins[i]]+1,dp[j]);
                }else{
                    if(i==0){
                        if(j%coins[i]==0){
dp[j]= j/coins[i];
                        }
                        
                    }else if(j-coins[i]<0){
                        dp[j]= dp[j];
                    }
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
        
    }
}
