class Solution {
    Map<Integer, List<Integer>> map;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map= new HashMap<>();

        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] p :prerequisites){
            map.get(p[0]).add(p[1]);
        }

        for(int i=0;i<numCourses;i++){
            Set<Integer> set = new HashSet<>();
            if(!dfs(i, set)){
                return false;
            }
        }
        return true;  
    }
    // 0- 1,2
    // 1-3
    // 3-4
    // 3-4
    // 4- <>

    public boolean dfs(Integer i,Set<Integer> set) {

        if(set.contains(i)){
            return false;
        }
        if(map.get(i).isEmpty()){
            return true;
        }
        set.add(i);

        for(Integer n:map.get(i)){
            if(!dfs(n, set)){
                return false;
            }
        }
        set.remove(i);
        return true;
    }
}
