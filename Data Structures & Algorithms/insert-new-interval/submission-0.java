class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

boolean inserted = false;

for (int i = 0; i < intervals.length; i++) {

    if (!inserted && intervals[i][0] >= newInterval[0]) {
        res.add(new int[]{newInterval[0], newInterval[1]});
        inserted = true;
    }

    res.add(intervals[i]);
}

if (!inserted) {
    res.add(new int[]{newInterval[0], newInterval[1]});
}
List<int[]> merged = new ArrayList<>();

for (int[] curr : res) {

    if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < curr[0]) {
        merged.add(curr);
    } else {
        merged.get(merged.size() - 1)[1] =
            Math.max(merged.get(merged.size() - 1)[1], curr[1]);
    }
}
return merged.toArray(new int[merged.size()][]);
        
    }
}
