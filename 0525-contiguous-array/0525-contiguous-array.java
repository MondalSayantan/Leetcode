class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        map.put(0, -1);;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)) {
                int length = i - map.get(sum);
                maxLength = Math.max(maxLength, length);
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
}