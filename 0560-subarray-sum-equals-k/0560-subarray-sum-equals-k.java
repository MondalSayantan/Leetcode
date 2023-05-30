class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        
        int sum = 0;
        int count = 0;
        for(int num: nums) {
            sum += num;
            if(prefix.containsKey(sum - k))
                count += prefix.get(sum - k);
            prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}