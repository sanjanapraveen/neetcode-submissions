class Solution {
    public int rob(int[] nums) {
        int prev1=nums[0], prev2=0;
        
        for(int i=1;i< nums.length;i++){
            int s= Math.max(nums[i]+prev2, prev1);
            prev2=prev1;
            prev1=s;
        }
        return Math.max(prev2, prev1);
        
    }
}
