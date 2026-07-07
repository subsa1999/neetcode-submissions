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
        int[] blockedTime = new int[1_000_001];

        for (Interval interval : intervals) {
            blockedTime[interval.start]++;
            blockedTime[interval.end]--;
        }

        int maxMeetingRoom = 0;

        int prefix = 0;

        for (int i = 0; i <= 1_000_000; ++i) {
            prefix += blockedTime[i];

            if (prefix > maxMeetingRoom) {
                maxMeetingRoom = prefix;
            }
        }

        return maxMeetingRoom;
    }
}
