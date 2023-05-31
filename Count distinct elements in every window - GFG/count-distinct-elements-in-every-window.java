//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < k; i++){
            if(!map.containsKey(A[i])) {
                map.put(A[i], 1);
                count++;
            } else{
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        
        ans.add(count);
        
        for(int i = k; i < n; i++) {
            int x = map.get(A[i-k]);
            if(x == 1) {
                map.remove(A[i-k]);   
                count--;
            }
            else
                map.put(A[i-k], map.get(A[i-k]) - 1);
                
            if(map.containsKey(A[i]))
                map.put(A[i], map.get(A[i]) + 1);
            else{
                map.put(A[i], 1);
                count++;
            }
            
            ans.add(count);
        }
        return ans;
    }
}

