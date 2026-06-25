class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length%groupSize!=0){
            return false;
        }

        Map<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<hand.length;i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i],1);
            }else{
                int x= map.get(hand[i]);
                map.put(hand[i],x+1);
            }
        }

        for(int n: hand){
            int s = groupSize;
            List<Integer> l = new ArrayList<>();
            while(map.containsKey(n)){
                n=n-1;
            }
            n=n+1;
            while(s>0){
                if(!map.containsKey(n)){
                    break;
                }
                l.add(n);
                s--;
                n++;
                
            }
            if(s==0){
                for(int i:l){
                    System.out.println(i);
                    int x= map.get(i);
                    map.put(i, x-1);
                    if(map.get(i)==0){
                        map.remove(i);
                    }
                }
            }

        }




        return (map.size()==0)? true:false;
        
    }
}
