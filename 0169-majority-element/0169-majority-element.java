class Solution {
    public int majorityElement(int[] arr) {
        int res = arr[0];
        int count = 1;
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == res)
                count++;
            else{
                count--;
            }
            if(count == 0) {
                count = 1;   
                res = arr[i];
            }
        }
        
        return res;
    }
}