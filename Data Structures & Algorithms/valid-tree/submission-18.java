class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {

        for(int i=0;i< n;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] e: edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        
        if(!dfs(0, 0)){
            return false;
        }
        
        return visited.size()==n;

    }


    public boolean dfs(int i, int parent) {

        if(set.contains(i)){
            return false;
        }
        set.add(i);
        visited.add(i);

        for(int e: map.get(i)){
            if(i==e){
                return false;
            }
            if(parent!= e){
                if(!dfs(e,i)){
                    return false;
                }
            }
        }

        set.remove(i);
        return true;

    }
}
