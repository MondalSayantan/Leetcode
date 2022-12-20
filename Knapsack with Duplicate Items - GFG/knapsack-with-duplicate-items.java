//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W+1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < W+1; j++){
                dp[i][j] = -1;
            }
        }
        return profit(N, W, val, wt, 0, new HashMap<String,Integer>(), dp);
    }
    
    private static int profit(int n, int target, int profits[], int weights[], int currentItem, HashMap<String, Integer> memo, int[][] dp) {
        
        if(currentItem == n || target == 0)
            return 0;
        
        int currentItemWeight = weights[currentItem];
        int currentItemProfit = profits[currentItem];
        
        String currentKey = Integer.toString(currentItem) + "-" + Integer.toString(target);
        
        // if(memo.containsKey(currentKey))
        //     return memo.get(currentKey);
        
        if(dp[currentItem][target] != -1)
            return dp[currentItem][target];
        
        int consider = 0;
        
        if(currentItemWeight <= target)
            consider = profit(n, target - currentItemWeight, profits, weights, currentItem, memo, dp) + currentItemProfit;
        
        int notConsider = profit(n, target, profits, weights, currentItem+1, memo, dp);
        
        // memo.put(currentKey, Math.max(consider, notConsider));
        dp[currentItem][target] = Math.max(consider, notConsider);
        
        return Math.max(consider, notConsider);
            
        
    }
}