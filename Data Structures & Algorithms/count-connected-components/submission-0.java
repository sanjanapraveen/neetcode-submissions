    public class DSU {
        int[] parent ;
        int[] rank ;

        public DSU (int size){
            parent = new int[size];
            rank = new int[size];
        
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
            rank[i]=1;
        }}
    

    public int findParent(int n) {
        int res = n;
        while (res!= parent[res]){
        parent[n]=parent[parent[n]];
        res = parent[n];

        }
        return res;

    }
    public boolean union(int i, int j) {
        int p1= findParent(i);
        int p2 = findParent(j);
        System.out.println(p1);
                System.out.println(p2);

        if (p1==p2){
            return false; //no union required
        }

        if (rank[p1]>rank[p2]){
            parent[p1] = p2;
            rank[p2]= rank[p2]+ rank[p1];
        }else{
            parent[p2] = p1;
            rank[p1]= rank[p1]+ rank[p2];
        }
        return true;
    }}
class Solution {


    public int countComponents(int n, int[][] edges) {
//initially 1 for LL OF THE COMOPponents as they are allasuumned to be disjoint

    DSU dsu= new DSU(n);    
    int res =n ;//assume result is max
    for(int [] edge : edges){
    
        if (dsu.union(edge[0], edge[1])){
            res--;
        }

    }

    return res;

    }


}
