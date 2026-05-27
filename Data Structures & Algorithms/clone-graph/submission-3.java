/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> v = new HashMap<>();
    public Node cloneGraph(Node node) {
        


        return dfs(node);
        
    }

    public Node dfs(Node node) {
        if(node==null){
            return null;
        }
        if(v.containsKey(node.val)){
            return v.get(node.val);
        }

        Node dummy = new Node(node.val);
        v.put(node.val,dummy);
        
        for(Node n: node.neighbors){

dummy.neighbors.add(dfs(n))   ;         
        }
        

        
        return dummy;
        
    }
}