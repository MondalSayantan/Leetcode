class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums, target);
        int lastPosition = findLastPosition(nums, target);
        int[] arr = {firstPosition, lastPosition};
        return arr;
    }
    
    private static int findFirstPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                end = mid - 1; // Adjusted the index update
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (start < nums.length && nums[start] == target)
            return start;
        return -1;
    }
    
    private static int findLastPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                start = mid + 1; // Adjusted the index update
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        if (end >= 0 && nums[end] == target)
            return end;
        return -1;
    }
}
