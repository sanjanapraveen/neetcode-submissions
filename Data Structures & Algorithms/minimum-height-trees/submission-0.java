class Solution {
    Integer overAllMin= Integer.MAX_VALUE;
    int[] rootLevelMax;
    HashMap<Integer,List<Integer>> map= new HashMap<>();
    List<Integer> res= new ArrayList<>();
    int rlm=0;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        rootLevelMax= new int[n];

        //create neighbours map
        for(int[] e:edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        //do dfs for eacch node to return maxHeight
        for(int i=0;i<n;i++){
            Set<Integer> visited= new HashSet<>();
            rlm= 0;
            dfs(i,-1,visited,0);
            rootLevelMax[i]= rlm;
            overAllMin= Math.min(overAllMin, rlm);
        }

        //find all nodes associated with 
        for(int i=0;i<n;i++){
            if(rootLevelMax[i]==overAllMin){
                res.add(i);
            }
        }
        return res;
    }
    public void dfs(int child, int parent, Set<Integer> visited, int curLen){
        if(visited.size()==map.size()){
            return ;
        }
        curLen++;
        visited.add(child);
        
        for(int n: map.get(child)){
            if(n==parent){
                continue;
            }  
            dfs(n, child,visited,curLen);
            

        }
        rlm = Math.max(rlm,curLen);

        return;
    }

    
}