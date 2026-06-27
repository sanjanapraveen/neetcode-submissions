class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i=0;i< s.length();i++){
            if(s.charAt(i)=='('){
                left.push(i);
            }
            if(s.charAt(i)=='*'){
                star.push(i);
            }
            if(s.charAt(i)==')'){
                if(!left.isEmpty() && left.peek()< i){
                    left.pop();
                    continue;
                }else if(!star.isEmpty() && star.peek()< i){
                     star.pop();
                    continue;
                }{
                    System.out.println("here1");
                    return false;
                }
            }
        }
        while(!left.isEmpty() && !star.isEmpty()){
            int l = left.pop();
            int st = star.pop();
            if(l>st){
                System.out.println("here2");
                return false;
            }
        }
        if(left.size()>0){System.out.println("here3");

            return false;
        }
        return true;
        
    }
}
