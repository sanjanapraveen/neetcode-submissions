class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, n+2);
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int l = nums[i];
            while(l>=0){

                if(l+i<=n-1 && dp[l+i]<n+2){

                    dp[i]= Math.min(dp[i], 1+dp[l+i]);

                }
                l--;
            }

        }

        return dp[0];
        
    }
}
