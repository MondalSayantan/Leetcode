class Solution {
    public long maxStrength(int[] nums) {
        return max(nums, 1, 0, false);
    }
    
    public static long max(int[] nums, long strength, int currentIndex, boolean picked) {
        if (currentIndex == nums.length){
            if(!picked){
                long smallestNumber = Long.MIN_VALUE;
                for(int num: nums)
                    smallestNumber = Math.max(smallestNumber, num);
                return smallestNumber;
            }
            return strength;
        }
        
        if(strength == 0)
            return 0;
        
        long consider = max(nums, strength * nums[currentIndex], currentIndex + 1, true);
        long notConsider = max(nums, strength, currentIndex + 1, picked);

        return Math.max(consider, notConsider);
    }
}