class Solution {
    Map<String,List<Pair>> map = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res= new double[queries.size()];
        for(int i=0;i<values.length;i++){
            String f =equations.get(i).get(0);
            String s =equations.get(i).get(1);
            map.putIfAbsent(f, new ArrayList<>());
            map.get(f).add(new Pair(s,values[i]));
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(new Pair(f,1/values[i]));
        }
        int i=0;
        for(List<String> q: queries){
            Set<String> v= new HashSet<>();
            res[i]= dfs(q,v);
            i++;
        }
        return res;
    }

    public double dfs(List<String> q,Set<String> v) {
    if (!map.containsKey(q.get(0))|| !map.containsKey(q.get(1))){
        return -1.0;
    }
    if (q.get(0).equals(q.get(1))){
        return 1.0;
    }
    v.add(q.get(0));
    
    for(Pair p: map.get(q.get(0))){
    if(!v.contains(p.letter)){
        double num = dfs(Arrays.asList(p.letter, q.get(1)),v);
        if(num!=-1.0){
            return p.num* num;
        }
        
       }
    }

       return -1.0;
    }
    






}


public class Pair {

    String letter;
    double num;

    public Pair( String letter,double num){
        this.letter = letter;
        this.num = num;
    }
}