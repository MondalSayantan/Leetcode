class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return binary(start, end, nums, target);
    }
    
    private static int binary(int start, int end, int[] nums, int target) {
        if (start > end)
            return -1;
        else {
            int mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid])
                return binary(mid + 1, end, nums, target); // Adjusted the start index
            if (target < nums[mid])
                return binary(start, mid - 1, nums, target); // Adjusted the end index
        }
        return -1;
    }
}
