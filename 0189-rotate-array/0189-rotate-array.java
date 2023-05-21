class Solution {
    public void rotate(int[] nums, int k) {
        while(k > nums.length){
            k = k - nums.length;
        }
        reverse(0, nums.length - k -1, nums);
        reverse(nums.length - k, nums.length - 1, nums);
        reverse(0, nums.length - 1, nums);
    }
    
    static void reverse(int low, int high, int[] arr) {
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    } 
}