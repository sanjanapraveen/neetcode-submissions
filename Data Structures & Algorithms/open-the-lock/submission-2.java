class Solution {
    
    Queue<String> q= new LinkedList<>();
    public int openLock(String[] deadends, String target) {
        Set<String>deads= new HashSet<>();
   
        for(String d: deadends){
            deads.add(d);
        }
    if(deads.contains("0000")){
      return -1;
    }
        q.add("0000");
        int res =0;
        
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                String e= q.poll();
                if(e.equals(target)){
                    return res;
                }
                for(String c : children(e))
                if(!deads.contains(c)){
                    deads.add(c);
                    q.add(c);
                }
            }
            res++;
        }
        return -1;

        
    }
    public List<String> children(String parent){
       List<String> res = new ArrayList<>();
       for(int i=0;i<4;i++){
        Character c = parent.toCharArray()[i];
        int n = Character.getNumericValue(c);
        int up= (n+10+1)%10;
        int down= (n+10-1)%10;
        String sub = parent.substring(0, i);
String remainder = parent.substring(i+1);
        res.add(sub+String.valueOf(up)+remainder);
        res.add(sub+String.valueOf(down)+remainder);
       }
       return res;
    }
}