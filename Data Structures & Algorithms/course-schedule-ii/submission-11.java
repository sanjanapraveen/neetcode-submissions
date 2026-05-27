class Solution {
    Map<Integer,List<Integer>> map= new HashMap<>();
    List<Integer> res ;
    Set<Integer> v ;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res=  new ArrayList<>();
        v= new HashSet<>();

        for(int[] p:prerequisites){
            map.putIfAbsent(p[0],new ArrayList<Integer>());
            map.get(p[0]).add(p[1]);

        }
        for(int i=0;i<numCourses;i++){
            Set<Integer> c= new HashSet<>();
            if(!dfs(i,c)){
                return new int[]{};
            }
        }
        return res.stream().mapToInt(i->i).toArray();

        
    }

    public boolean dfs(int crs, Set<Integer> cy){
        if(cy.contains(crs)){
            return false;
        }
        if(v.contains(crs)){
            return true;
        }
        cy.add(crs);
        if(map.get(crs)!=null){
        for(int c: map.get(crs)){
            if(!dfs(c,cy)){
                return false;
            }
        }
        }

        cy.remove(crs);
        v.add(crs);
        res.add(crs);
        
        return true;
    }
}
