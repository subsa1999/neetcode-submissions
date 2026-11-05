class Solution {
    public int majorityElement(int[] nums) {
        int key = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == key) {
                count++;
            } else {
                if (count == 1) {
                    key = nums[i];
                } else {
                    count--;
                }
            }
        }

        return key;
    }
}