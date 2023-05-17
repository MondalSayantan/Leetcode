class NumArray {
    int[] arr = new int[10000];
    public NumArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] + prefix[i-1];
        }
        if(left == 0) {
            return prefix[right];
        } else {
            return prefix[right] - prefix[left - 1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */