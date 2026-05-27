class Solution {
    Set<Integer> v= new HashSet<Integer>();
    Map<Integer,List<Integer>> map= new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        int res=0;

        //create a pre req map
        for(int[] e :edges){
            map.putIfAbsent(e[0],new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.putIfAbsent(e[1],new ArrayList<>());
            map.get(e[1]).add(e[0]);
        }
        //iterate through each element, if not visited, increase count of re after
        for(int i=0;i<n;i++){
            if(!v.contains(i)){
                dfs(i,-1);
                res++;
            }
        }
        return res;
    }

    public void dfs(int i, int parent) {
        if(v.contains(i)){
            return;
        }
        v.add(i);
        //iterate through each element, if not visited, increase count of re after
        if(map.get(i)!=null){
        for(int n: map.get(i)){
            if(n==parent){
                continue;
            }
                dfs(n, i);
            
        }
        }

        return ;
    }
}
