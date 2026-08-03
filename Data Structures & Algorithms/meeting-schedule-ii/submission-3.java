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
        List<Integer> linePoints = new ArrayList<>();

        for (var interval : intervals) {
            linePoints.add(interval.start);
            linePoints.add(-1 * interval.end);
        }

        Collections.sort(linePoints, Comparator.comparingInt(i -> Math.abs(i)));

        int meetingRooms = 0, maxMeetingRooms = 0;

        for (int i = 0; i < linePoints.size(); ) {
            int key = Math.abs(linePoints.get(i));
            int step = 0;

            while (i < linePoints.size() && key == Math.abs(linePoints.get(i))) {
                step += linePoints.get(i) >= 0 ? 1 : -1;
                ++i;
            }

            meetingRooms += step;
            maxMeetingRooms = Math.max(maxMeetingRooms, meetingRooms);
        }

        return maxMeetingRooms;
    }
}
