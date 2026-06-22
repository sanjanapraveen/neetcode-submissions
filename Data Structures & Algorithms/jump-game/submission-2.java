class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        boolean[] j = new boolean[n];
        j[n-1]= true;
        for(int i=n-2;i>=0;i--){
            int step= nums[i];
            while(step>=0){
            if(step+i<=n-1 && j[step+i]==true ){
                j[i]= true;
                break;
            }
            step--;
            }

        }
        return j[0];
        
    }
}
