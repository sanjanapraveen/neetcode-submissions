class Solution {
        Map<Integer,List<Integer>> map= new HashMap<>();
        
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        
        for(int i=1;i<=n;i++){
            map.putIfAbsent(i, new ArrayList<>());
        }

        for(int[] e: edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            boolean[] v= new boolean[n+1];
            if(dfs(e[0],-1,v)){
                return e;
            }
        }
        return new int[]{};

        
    }

    public boolean dfs(int child, int parent,boolean[] v) { //send true if cycle exists
        if(v[child]==true){

            return true;

        }
        v[child]=true;

        for(int n : map.get(child)){
           if(n==parent){
            continue;
           }
            if(dfs(n,child,v)){
                return true;
            }
        }
        return false;

        
    }
}
