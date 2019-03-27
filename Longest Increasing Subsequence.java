class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        dp[0] = 1;
        int maxlength = 1;
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(maxlength < dp[i])
                maxlength = dp[i];
        }
        return maxlength;
    }
}
