class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxKadane = kadane(nums, n);
        int maxCircular = 0;
        
        for (int i = 0; i < n; i++) {
            maxCircular += nums[i];
            nums[i] = -nums[i]; // Reverse the signs of the numbers
        }
        
        // Calculate the maximum subarray sum in the circular array
        maxCircular += kadane(nums, n);
        
        if (maxCircular > maxKadane && maxCircular != 0) {
            return maxCircular;
        } else {
            return maxKadane;
        }
    }
    
    static int kadane(int a[], int n) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;
        
        for(int i = 0; i < n; i++) {
            max_ending_here += a[i];
            if(max_ending_here > max_so_far)
                max_so_far = max_ending_here;
            if(max_ending_here < 0)
                max_ending_here = 0;
        }
        
        return max_so_far;
    }
    
}