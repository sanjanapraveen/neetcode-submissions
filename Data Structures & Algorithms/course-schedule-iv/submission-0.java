class Solution {
    Map<Integer,List<Integer>> map= new HashMap<>();
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res= new ArrayList<>();
        for(int[] p:prerequisites){
            map.putIfAbsent(p[0], new ArrayList<>());
            map.get(p[0]).add(p[1]);
        }
        for(int[] q:queries){
            Set<Integer> v= new HashSet<Integer>();
            res.add(dfs(q,v));
        }
        return res;

        
    }

//return if pre req or not
    public boolean dfs(int[] q,Set<Integer> v) {
        if(map.get(q[0])==null){
            return false;
        }
        if(map.get(q[0]).contains(q[1])){
            return true;
        }

        if(v.contains(q[0])){
            return false; //not possible cycle detected
        }
        v.add(q[0]);

        for(int p:map.get(q[0])){
            if(dfs(new int[]{p,q[1]},v)){
                return true;
            }
        }
        return false;

        
    }
}