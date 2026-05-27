class Solution {
    public int rob(int[] nums) {
        int prev1=0, prev2=nums[0];
        for(int i=1;i<nums.length;i++){
            int r= Math.max(nums[i]+prev1, prev2);
            prev1=prev2;
            prev2= r;

        }

        return prev2;
        
    }
}
