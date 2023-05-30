//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            boolean arr1[] = new boolean[n];
            boolean arr2[] = new boolean[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = str[i].equals("1") ? true : false;
            }
            str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr2[i] = str[i].equals("1") ? true : false;
            }

            int ans = new Solution().longestCommonSum(arr1, arr2, n);

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int longestCommonSum(boolean arr1[], boolean arr2[], int n) {
        // code here
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            temp[i] = (arr1[i] ? 1: 0 ) - (arr2[i] ? 1: 0);
        }
        
        int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0; i < n; i++) {
            sum += temp[i];
            if(map.containsKey(sum)){
                int length = i - map.get(sum);
                maxLength = Math.max(maxLength, length);
            }
            else {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
}