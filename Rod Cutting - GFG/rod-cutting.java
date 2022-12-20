//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        return profit(price, n, 0, new HashMap<String, Integer>());
    }
    
    private static int profit(int[] price, int length, int currentIndex, HashMap<String, Integer> memo){
        
        if(length == 0)
            return 0;
        
        if(currentIndex >= price.length)
            return 0;
            
        String currentKey = Integer.toString(currentIndex) + "-" + Integer.toString(length);
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int currentIndexVal = price[currentIndex];
        int currentPieceLength = currentIndex + 1;
        int consider = 0;
        if (currentPieceLength <= length)
            consider = profit(price, length - currentPieceLength, currentIndex, memo) + currentIndexVal;
        int notConsider = profit(price, length, currentIndex+1, memo);
        
        memo.put(currentKey, Math.max(consider, notConsider));
        
        return Math.max(consider, notConsider);
        
    }
}