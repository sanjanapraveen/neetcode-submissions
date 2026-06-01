class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        return Math.max(dp(nums,0, nums.length-1),dp(nums,1, nums.length));
  
    }
    public int dp(int[] nums, int start, int end){

        int prev2=0, prev1=nums[start];

        for(int i=start+1;i< end;i++){
            int s = Math.max(nums[i]+prev2, prev1);
            prev2= prev1;
            prev1=s;
        }
        return Math.max(prev2, prev1);

    }
}
