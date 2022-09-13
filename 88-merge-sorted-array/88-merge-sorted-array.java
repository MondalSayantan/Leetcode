class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] first = Arrays.copyOfRange(nums1, 0, m);
        int[] second = Arrays.copyOfRange(nums2, 0, n);
        
        int[] mix = new int[first.length + second.length];
        int i = 0;  
        int j = 0;  
        int k = 0; 

        while ( i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        
        for(int a = 0; a < mix.length; a++) {
            nums1[a] = mix[a];
        }
    }
}