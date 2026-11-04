class Solution {
    private void swap(int[] a, int f, int t) {
        int x = a[f];
        a[f] = a[t];
        a[t] = x;
    }

    public int removeElement(int[] nums, int val) {
        int write = 0;

        for (int read = 0; read < nums.length; ++read) {
            if (nums[read] == val) {
                continue;
            } else {
                swap(nums, write, read);
                write++;
            }
        }

        return write;
    }
}
