class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> triplets = new HashSet<>();

        for (int i = 0; i < nums.length; ++i) {
            List<int[]> list = twoSum(nums, i + 1, nums.length - 1, -nums[i]);

            for (int[] axx : list) {
                triplets.add(List.of(nums[i], axx[0], axx[1]));
            }
        }

        return new ArrayList<>(triplets);
    }

    List<int[]> twoSum(int[] arr, int left, int right, int target) {
        List<int[]> list = new ArrayList<>();

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                list.add(new int[] {arr[left], arr[right]});
                right--;
                left++;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return list;
    }
}
