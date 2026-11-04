class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int a = numbers[left];
            int b = numbers[right];

            int sum = a + b;

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {};
    }
}
