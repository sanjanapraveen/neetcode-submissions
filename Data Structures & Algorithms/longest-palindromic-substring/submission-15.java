class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        int start=0, maxLen=0;
        boolean[][] dp = new boolean[n][n];

        for(int l=n-1;l>=0;l--){
          for(int r=l;r<n;r++){
            if(s.charAt(l)==s.charAt(r) &&(r-l<=2 || dp[l+1][r-1])){
                dp[l][r] = true;
                if(r-l+1>=maxLen){
                    start = l;
                    maxLen = r-l+1;
                }
            }
          }
        }
        return s.substring(start, start+maxLen);   
    }
}
