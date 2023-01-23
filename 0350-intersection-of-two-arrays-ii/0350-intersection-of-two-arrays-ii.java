class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer> ();
        for(int num: nums1) {
            if(!memo.containsKey(num))
                memo.put(num, 1);
            else memo.put(num, memo.get(num)+1);
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int num: nums2) {
            if(memo.containsKey(num) && memo.get(num) != 0){
                answer.add(num);
                memo.put(num, memo.get(num)-1);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}