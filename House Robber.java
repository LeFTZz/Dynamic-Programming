import java.util.Arrays;
class Solution {
    public int rob(int[] nums) {
        int a = nums.length;
        if(a == 0){
            return 0; //nums is null
        }
        if(a == 1){
            return nums[0]; //return the first house
        }
        // the best sulotion for house i is dp[i]
        int[] dp = new int[a+3];
        Arrays.fill(dp,0);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < a; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[a-1];
    }
}
