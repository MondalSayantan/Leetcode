class Solution {
    public int minCut(String s) {
        if(s.length() == 1)
            return 0;
        return minCuts(0, s.length() - 1, s, new HashMap<String, Integer> ());   
    }
    
    private static int minCuts(int start, int end, String s, HashMap<String, Integer> memo) {
        if(palindrome(start, end, s))
            return 0;
        
        int ans = 20001;
        String currentKey = start + "-" + end;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        // start, start+1, start+2 .... end-1
        for(int i = start; i < end; i++) {
            // String leftString = s.substring(0, i);
            if(palindrome(start, i, s)) {
                int tempAns = 1 + minCuts(i+1, end, s, memo);
                ans = Math.min(ans, tempAns);
            }
        }
        memo.put(currentKey, ans);
        return ans;
    }
    
    private static boolean palindrome(int start, int end, String s) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            
            start++;
            end--;
        }
        return true;
    }
}