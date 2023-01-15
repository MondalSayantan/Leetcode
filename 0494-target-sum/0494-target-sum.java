class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sum(nums, 0, target);
    }

    private static int sum(int[] nums, int currentIndex, int target) {
        if(target == 0 && currentIndex == nums.length)
            return 1;
        if(currentIndex >= nums.length)
            return 0;
        
        int add = sum(nums, currentIndex+1, target - nums[currentIndex]);
        int subtract = sum(nums, currentIndex+1, target + nums[currentIndex]);

        return add + subtract;
    }
}