class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] lastRange = intervals[0];
        int skippedCount = 0;

        for (int i = 1; i < intervals.length; ++i) {
            int[] currentRange = intervals[i];

            boolean startsInBetween = lastRange[0] <= currentRange[0] && currentRange[0] < lastRange[1];
            boolean endsInBetween =  lastRange[0] < currentRange[1] && currentRange[1] <= lastRange[1];

            if (startsInBetween || endsInBetween) {
                boolean currentEndsEarly = currentRange[1] < lastRange[1];
                if (currentEndsEarly) {
                    // System.out.printf("substituting %d,%d with %d,%d\n", 
                    //     lastRange[0], lastRange[1], currentRange[0], currentRange[1]);

                    // substitute
                    lastRange = currentRange;
                    skippedCount++;
                } else {
                    // System.out.printf("skipping with %d,%d\n", 
                    //     currentRange[0], currentRange[1]);

                    // skip current
                    skippedCount++;
                }
            } else {
                // System.out.printf("Taking with %d,%d\n", 
                //         currentRange[0], currentRange[1]);
                lastRange = currentRange;
            }
        }

        return skippedCount;
    }
}
