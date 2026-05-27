class Solution {
    HashSet<Integer> visiting = new HashSet<>();
    HashSet<Integer> visited = new HashSet<>();
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {

        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return dfs(0,-1) && visited.size()==n;

    }
    public boolean dfs(int n, int caller) {
        if(visiting.contains(n)) return false;

        visiting.add(n);

        for(int e: map.get(n)){
            if(e==caller) continue;
            if(!dfs(e,n)) return false;
        }
        visiting.remove(n);
        visited.add(n);
        return true;

    }
}
