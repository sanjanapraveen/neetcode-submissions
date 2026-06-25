class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;
        int matchCount=0;
        boolean[] ignore = new boolean[n];
        boolean[] got = new boolean[3];

    for(int i=0;i<3;i++){
        int t= target[i];
        for(int j=0;j<n;j++){
            if(ignore[j]==false){
                if(t<triplets[j][i]){
                    ignore[j]=true;
                }
            }
            }
        }
            for(int i=0;i<3;i++){
        int t= target[i];
        for(int j=0;j<n;j++){
            if(ignore[j]==false){
                if(t==triplets[j][i] && got[i]==false){
                    System.out.println("j"+j+"i"+i);
                    matchCount++;
                    got[i]=true;
                }
            }
            }
        }
    return matchCount==3?true:false;
        
    }
}
