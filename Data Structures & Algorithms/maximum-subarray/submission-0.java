class Solution {
    public int maxSubArray(int[] nums) {
        int mas= nums[0];
        int curSum =0;
        for(int i=0;i< nums.length;i++){
            if (curSum<0){
                curSum=0;
            }
            curSum+=nums[i];
            mas=Math.max(mas,curSum);
        }
        return mas;
        
    }
}
