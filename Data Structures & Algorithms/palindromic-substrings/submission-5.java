class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        int res=0;
        
        for(int l=n;l>=0;l--){
            for(int r=l;r< n;r++){
                if(s.charAt(l)==s.charAt(r) &&( r-l<=2 || dp[l+1][r-1]==true)){
                    dp[l][r]=true;
                    res++;
                }
            }
        }
        return res;    
    }
}
