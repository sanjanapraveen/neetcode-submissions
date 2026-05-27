class Solution {
    Map<Integer, List<Integer>> map;
    public boolean validTree(int n, int[][] edges) {
        map= new HashMap<>();
        
        if(edges.length<n-1){
            return false;
        }
        for(int[] e: edges){
            map.putIfAbsent(e[0],new ArrayList<>());
            map.putIfAbsent(e[1],new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);

        }
    
            Set<Integer> cycle= new HashSet<>();
            if(!dfs(0, -1, cycle)){
                return false;
            }
        
        return cycle.size()==n;
    }
    public boolean dfs(int child, int parent,Set<Integer> cycle) {
        if (cycle.contains(child)){
            return false;
        }
        cycle.add(child);
        if(map.get(child)!=null){
        for(int n: map.get(child)){
            if(n==parent){
                continue;
            }else{
                if(!dfs(n,child,cycle)){ 
                    return false;
                }
            }

        }
        }

        return true;
    }
}
