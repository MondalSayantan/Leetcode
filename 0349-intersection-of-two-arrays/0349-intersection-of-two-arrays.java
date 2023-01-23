class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean> ();
        for(int num: nums1) {
            if(!memo.containsKey(num))
                memo.put(num, true);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int num: nums2) {
            if(memo.containsKey(num) && memo.get(num)) {
                answer.add(num);
                memo.put(num, false);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}