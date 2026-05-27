class Solution {
    public int tribonacci(int n) {
        int f=0, s=1, t=1;
        if(n==0){
            return f;
        }
        if(n==1){
            return s;
        }
        if(n==2){
            return t;
        }

        for(int i=2;i<n;i++){
            int sum = t+s+f;
            
            f=s;
            s=t;
            t=sum;
        }
        return t;
        
    }
}