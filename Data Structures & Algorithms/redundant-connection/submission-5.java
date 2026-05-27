class Solution {
    Set<Integer> set = new HashSet<>();
    Stack<int[]> stack = new Stack<>();

    Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] findRedundantConnection(int[][] edges) {
        for(int i=0;i< edges.length;i++){
            map.put(i+1, new ArrayList<>());
        }
        for(int[] e:edges){
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            if(!dfs(e[0], -1)){
                return e;
            }
        }
        return new int[]{};
    }

    public boolean dfs(int i, int parent){ 

        if(set.contains(i)){
            return false;
        }
        set.add(i);

        for(int n: map.get(i)){
            if(n!=parent){
                if(!dfs(n,i)){
                    return false;
                }
            }
        }
        set.remove(i);
        return true;

    }
}
