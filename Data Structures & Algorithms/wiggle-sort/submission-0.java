class Solution {
    public void wiggleSort(int[] nums) {
        // apply partition algorithm
        int pivot;
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) >> 1;

        while (lo < hi) {
            pivot = partition(nums, lo, hi);

            if (pivot == mid) {
                break;
            }

            if (pivot > mid) {
                hi = pivot - 1;
            } else {
                lo = pivot + 1;
            }
        }

        // TBD next step
        int[] res = new int[nums.length];
        int first = 0;
        int second = mid + 1;
        
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) res[i] = nums[first++];
            else res[i] = nums[second++];
        }

        System.arraycopy(res, 0, nums, 0, nums.length);
    }

    int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int leftWriter = lo;

        for (int i = lo; i < hi; ++i) {
            if (nums[i] <= pivot) { // if smaller
                swap(nums, leftWriter, i);
                leftWriter++;
            }
        }

        swap(nums, leftWriter, hi);
        return leftWriter;
    }

    void swap(int[] ar, int f, int t) {
        int x = ar[f];
        ar[f] = ar[t];
        ar[t] = x;
    }
}

// n0 <= n1 >= n2 <= n3 >= n4 <= n5 >= ...
// 3 5 6 2 1 6 4
// 1 2 3 4 5 6 6
// 1 5 2 6 3 6 4

// if we can break it to two half
// [lower half] <= [higher half]
// l0 <= h0 >= l1 <= h1