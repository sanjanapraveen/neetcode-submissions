class Solution {
    public int[][] merge(int[][] intervals) {
        int j=1;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            res.add(intervals[0]);
            while(j< intervals.length){
                int[] next = intervals[j];
                int[] curr = res.get(res.size()-1);
                if((curr[1]>= next[0]) ){
                    res.remove(res.size()-1);
                    int f= Math.min(Math.min(intervals[j][0],curr[0]),Math.min(intervals[j][1],curr[0]));
                    int s= Math.max(Math.max(intervals[j][0],curr[0]),Math.max(intervals[j][1],curr[1]));

                    res.add(new int[]{f,s});
                }else{
                    res.add(intervals[j]);
                }
                j++;
            } 

            return res.toArray(new int[res.size()][]); 
    }
}
