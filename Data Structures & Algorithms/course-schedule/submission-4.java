class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create a map of course an pre req
        //do dfs on each course if course is already sisted send false, else, true

        for(int[] p:prerequisites){
            map.putIfAbsent(p[0],new ArrayList<Integer>());
            map.get(p[0]).add(p[1]);
        }

        for(int i=0;i<numCourses;i++){
            Set<Integer> v= new HashSet<>();
            if(!dfs(i,v)){
                return false;
            }
        }
        return true;
        
    }
    public boolean dfs(int c,Set<Integer> v) {
        if(v.contains(c)){
            return false;
        }
        if(map.get(c)==null){
            return true;
        }
        v.add(c);
        for(int p:map.get(c)){
            if(!dfs(p,v)){
                return false;
            }
            
        }
        v.remove(c);

        return true;
        
    }
}
