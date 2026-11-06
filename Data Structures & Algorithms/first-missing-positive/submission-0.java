class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean[] seen = new boolean[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            if (1 <= nums[i] && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i] && nums[i] != (i + 1)) {
                int x = nums[i];
                int y = nums[x - 1];
                nums[i] = y;
                nums[x - 1] = x;
                --i;
            }
            // System.out.println(Arrays.toString(nums));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }
}