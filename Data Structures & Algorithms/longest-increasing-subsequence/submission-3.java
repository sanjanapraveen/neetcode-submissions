class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];

        int res =1;

        for(int i=n-1;i>=0;i--){
            lis[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    lis[i]= Math.max(lis[i],1+lis[j]);
                }
            }
            if(lis[i]>res){
                res=lis[i];
            }
        }   

        return res;     
    }
}
