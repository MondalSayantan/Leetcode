class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0, text1.length(), text2.length(), new HashMap<String, Integer> ());
    }
 
    private static int lcs(String s1, String s2, int i, int j, int m, int n, HashMap<String, Integer> memo) {
        if(i >= m || j >= n)
            return 0;
        
        int length = 0;
        
        String currentKey = i + "-" + j;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        if(s1.charAt(i) == s2.charAt(j)) {
            length = 1 + lcs(s1, s2, i+1, j+1, m, n, memo);
        } else {
            int incrementj = lcs(s1, s2, i, j+1, m, n, memo);
            int incrementi = lcs(s1, s2, i+1, j, m, n, memo);
            length = Math.max(incrementi, incrementj);
        }
        
        memo.put(currentKey, length);
        return length;
    }
    
}