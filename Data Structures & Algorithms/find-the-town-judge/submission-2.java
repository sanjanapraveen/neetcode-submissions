class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,List<Integer>> map2 = new HashMap<>();

        for(int[] t: trust){
            map.computeIfAbsent(t[0], k -> new ArrayList<>()).add(t[1]);
            map2.computeIfAbsent(t[1], k -> new ArrayList<>()).add(t[0]);
        }

        for(int i=1;i<n+1;i++){
           
            if(map.get(i)==null && map2.get(i)!= null && map2.get(i).size()==n-1){
                return i;
            }
        }
        return -1;
        
    }
}