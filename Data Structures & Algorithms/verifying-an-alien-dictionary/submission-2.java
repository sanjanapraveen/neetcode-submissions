class Solution {
    int[] map;
    public boolean isAlienSorted(String[] words, String order) {
        //create map of letter ans numbers
        map = new int[26];

        for(int i=0;i<order.length();i++){
            map[order.charAt(i)-'a']=i;
        }

        for(int i=0;i< words.length-1;i++){
            if (!check(words[i],words[i+1])){
                return false;
            }
        }
        return true;
        
    }
    public boolean check(String word1, String word2) {
        int ptr1=0,ptr2=0;
        while(ptr1<word1.length() && ptr2<word2.length()){
            int i=map[word1.charAt(ptr1)-'a'];
            int j=map[word2.charAt(ptr2)-'a'];
            if(i>j){
                return false;
            }else if(i<j){
                return true;
            }else{
            ptr1++;
            ptr2++;
            }

        }

        return word1.length() <= word2.length();
        

        
    }
}