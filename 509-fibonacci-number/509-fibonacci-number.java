class Solution {
    public int fib(int n) {
        return fibonacci(n, new HashMap<Integer,Integer>());
    }
    
    private static int fibonacci(int n, HashMap<Integer,Integer> memo) {
        
        if (n == 0)
            return 0;
        
        if (n == 1)
            return 1;
        
        int currentKey = n;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int result = fibonacci(n-1, memo) + fibonacci(n-2, memo);
        
        memo.put(currentKey, result);
        
        return result;
        
    }
}