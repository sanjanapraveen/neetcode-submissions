class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev_1=cost[0];
        int prev_2= cost[1];
        int res=0;

        for(int i=2;i< cost.length;i++){
            System.out.println("here");
            res= cost[i]+ Math.min(prev_2 , prev_1);
            prev_1= prev_2;
            prev_2=res;
        }
        return  Math.min(prev_2,prev_1);
        
    }
}
