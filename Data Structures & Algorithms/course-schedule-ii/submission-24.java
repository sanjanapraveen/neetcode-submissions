class Solution {
    List<Integer> res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res= new ArrayList<>();

        for(int i=0;i<numCourses;i++){
           map.put(i, new ArrayList<>());
        }

        for(int[] p: prerequisites){
           map.get(p[0]).add(p[1]);
        }
        for(int i=0;i< numCourses;i++){

                if(!dfs(i, set)){
                return new int[]{};
            }
            }
                    int[] arr = new int[res.size()];    

        for (int i = 0; i < list.size(); i++)
            arr[i] =list.get(i);

return arr;

        }
    public boolean dfs(int i, Set<Integer> set) {
        if(set.contains(i)){
                return false;
        }

        if(res.contains(i)){
            return true;
        }

        set.add(i);
        for(int p: map.get(i)){
           if(!dfs(p,set)){
            return false;
           }
        }
        set.remove(i);
        res.add(i);
        list.add(i);
        return true;
        
    }

    


}
