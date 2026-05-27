class Solution {
    public int climbStairs(int n) {
        int before=0, prev=1; 
        int res=prev + before;
        for(int i=0;i<n;i++){
            res = prev+ before;
            before = prev;
            prev=res;
        }
        return res;
        
        
    }
}
