class Solution {
    HashSet<Integer> visited= new HashSet<>();
    Map<Integer, List<Integer>> map= new HashMap<>();
    public int countComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] e: edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i,-1);
                res++;
            }
        }

        return res;
    }

    public void dfs(int i, int parent){
        if(visited.contains(i)){
            return;
        }
        visited.add(i);

        for(int n : map.get(i)){
            if(n!= parent){
                dfs(n,i);
            }
        }
    }
}
