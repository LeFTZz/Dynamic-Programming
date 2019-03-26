import java.util.Arrays;
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+3];
        Arrays.fill(dp,0);
        // Initialize the first 2 staris.
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        // The ways of climbing to staris i is the sum of the ways of climbing to staris i - 1 
        // and the ways of climbing to staris i - 2.
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
}
