class Solution {
    public int longestPalindromeSubseq(String s) {
        String revStr = "";
        for(int i = s.length() - 1; i >= 0; i--)
            revStr = revStr + s.charAt(i);
        return lengthOfPalindrome(s, revStr, 0, 0, s.length(), s.length(), new HashMap<String, Integer> ());
    }
    
    private static int lengthOfPalindrome(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo) {
        if(i >= m || j >= n)
            return 0;
        
        int length = 0;
        
        String currentKey = i + "-" + j;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        if(s1.charAt(i) == s2.charAt(j)) {
            length = 1 + lengthOfPalindrome(s1, s2, i+1, j+1, m, n, memo);
        } else {
            int incrementj = lengthOfPalindrome(s1, s2, i, j+1, m, n, memo);
            int incrementi = lengthOfPalindrome(s1, s2, i+1, j, m, n, memo);
            length = Math.max(incrementi, incrementj);
        }
        
        memo.put(currentKey, length);
        return length;
    }
}