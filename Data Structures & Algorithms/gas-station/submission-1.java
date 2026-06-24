class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int gas_uptill=0;
        int visited=0;
        for(int i=0;i<n;i++){
            int j=i;
            while(visited<n){
                    if(gas[j]+gas_uptill<cost[j]){
                        visited=0;
                        gas_uptill=0;
                        break;
                    }
                    visited++;
                    if(visited==n){
                        return i;
                    }
                    gas_uptill+= gas[j]-cost[j];
                    j++;
                    if(j>=n){
                        j=n-j;
                    }
            }
            

        }
        return -1;
        
        
    }
}
