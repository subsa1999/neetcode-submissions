class Solution {
    public int[] productExceptSelf(int[] nums) {
        long[] suffix = new long[nums.length];

        for (int i = nums.length - 1; i >= 0; --i) {
            if (i == nums.length - 1) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = suffix[i + 1] * nums[i];
            }
        }

        long prefix = 1L;

        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            answer[i] = (int) (prefix * (i < (nums.length - 1) ? suffix[i + 1] : 1L));
            prefix *= nums[i];
        }

        return answer;
    }
}  
