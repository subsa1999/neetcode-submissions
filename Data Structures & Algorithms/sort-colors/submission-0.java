class Solution {
    void swap(int[] a , int f, int t) {
        int x = a[f];
        a[f] = a[t];
        a[t] = x;
    }

    public void sortColors(int[] nums) {
        int lo = 0;
        int mid = 0;
        int hi = nums.length - 1;

        while (mid <= hi) {
            if (nums[mid] == 0) {
                swap(nums, lo, mid);
                lo++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, hi);
                --hi;
            }
        }
    }
}