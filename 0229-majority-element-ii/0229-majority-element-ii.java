class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> answer = new ArrayList<>();
        for(int key: map.keySet()) {
            if(map.get(key) > nums.length/3) answer.add(key);
        }
        return answer;
    }
}