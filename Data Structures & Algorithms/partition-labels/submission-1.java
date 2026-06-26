class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<    Integer,Integer> fmap = new HashMap<>();
        List<Integer> res= new ArrayList<>();

        for(Character c: s.toCharArray()){
            if(!fmap.containsKey(c-'a')){
                fmap.put(c-'a',1);
            }else{
                fmap.put(c-'a',fmap.get(c-'a')+1);
            }
        }
        int start =0, end=0;

        while(start<=end && end< s.length()){
            Map<Integer,Integer> wordMap= new HashMap<>();
            while(end<s.length()){
                if(!wordMap.containsKey(s.charAt(end)-'a')){
                    wordMap.put(s.charAt(end)-'a',1);
                }else{
                    wordMap.put(s.charAt(end)-'a',wordMap.get(s.charAt(end)-'a')+1);
                }


                if(fmap.get(s.charAt(end)-'a')==wordMap.get(s.charAt(end)-'a')){
                    //check if all letters of teh set word have mat
                    int matchesNeeded = wordMap.size();
                    for (Map.Entry<Integer,Integer> entry : wordMap.entrySet()) {
                        if(wordMap.get(entry.getKey())==fmap.get(entry.getKey())){
                            matchesNeeded--;
                        }
                    }
                    if(matchesNeeded==0){
                        res.add(end-start+1);
                        start=end+1;
                    }
                }
                end++;
                
            
        }
        }
        return res;
    }
}
