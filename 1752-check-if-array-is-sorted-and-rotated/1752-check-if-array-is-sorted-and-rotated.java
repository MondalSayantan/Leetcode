class Solution {
    public boolean check(int[] nums) {
        int pivotalPoint = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (pivotalPoint != -1) {
                    return false;
                }
                pivotalPoint = i;
            }
        }

        if (pivotalPoint != -1) {
            if (nums[nums.length - 1] > nums[0]) {
                return false;
            }
        }

        return true;
    }
}
