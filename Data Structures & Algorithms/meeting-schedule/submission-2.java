/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()<=1){
            return true;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Interval curr= intervals.get(0);

        for(int i=1;i< intervals.size();i++){
            Interval next = intervals.get(i);
            if (curr.end> next.start){
                return false;
            }
            curr= intervals.get(i);
        }
        return true;

    }
}
