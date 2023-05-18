class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(j < n) {
            arr[k++] = nums2[j++];
        }
         while(i < m) {
            arr[k++] = nums1[i++];
        }
        for(int l = 0; l < arr.length; l++) {
            nums1[l] = arr[l];
        }
    }
}