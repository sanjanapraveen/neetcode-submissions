class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        int prev1=nums[0], prev2=0;

        for(int i=1;i<nums.length-1;i++){
            int res= Math.max(prev1, prev2+nums[i]);
            prev2=prev1;
            prev1=res;
        }
        int prev3=nums[1], prev4=0;

        for(int i=2;i<nums.length;i++){
            int res= Math.max(prev3, prev4+nums[i]);
            prev4=prev3;
            prev3=res;
        }
        return Math.max(prev1,prev3);
        
    }
}
