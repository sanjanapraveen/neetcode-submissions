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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0){
            return 0;
        }
        intervals.sort(Comparator.comparingInt(i -> i.start));

        Set<Integer> rooms = new HashSet<>();//this will cotain the time when a room will next be available
        rooms.add(intervals.get(0).end);
        int roomsNeeded=1;

        for(int i=1;i< intervals.size();i++){
            int start= intervals.get(i).start;
            int roomFound= 0;
            for(int j=0;j<=start;j++){
                if(rooms.contains(j)){
                    roomFound=j;
                    break;
                }
            }

            if(roomFound!=0){
                rooms.remove(roomFound);
            } else{
               roomsNeeded++ ;
            }           
            
            rooms.add(intervals.get(i).end);
            

            
        }


        return rooms.isEmpty()? 0: roomsNeeded;

    }
}
