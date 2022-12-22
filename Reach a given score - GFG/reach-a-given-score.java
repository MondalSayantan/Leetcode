//{ Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        int[] nums = new int[]{3,5,10};
        return totalWays(nums, 0, n, new HashMap<String, Integer>());
    }
    
    private static int totalWays(int[] nums, int currentIndex, int target, HashMap<String, Integer> memo) {
        if(target == 0)
            return 1;
        if(currentIndex == nums.length)
            return 0;
            
        String currentKey = currentIndex + "-" + target;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
            
        int currentIndexValue = nums[currentIndex];
        int consider = 0;
        
        if(currentIndexValue <= target)
            consider = totalWays(nums, currentIndex, target-currentIndexValue, memo);
        
        int notConsider = totalWays(nums, currentIndex+1, target, memo);
        
        memo.put(currentKey, consider + notConsider);
        return consider + notConsider;
    }
}