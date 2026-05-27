class Solution {

    public String encode(List<String> strs) {
        String res= new String();
        for(String str: strs){
            res= res+str.length()+"#"+str;
        }
        System.out.println(res);
        return res;

    }

    public List<String> decode(String str) { //str= 4#neet10#abcdefghij
        List<String> res = new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int j=i;
            while(j<str.length() && str.charAt(j)!='#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));

            res.add(str.substring(j+1, j+len+1));
            i=j+len+1;

        }
        return res;
        

    }
}
