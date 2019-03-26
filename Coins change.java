class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //先全部初始化为-1
        Arrays.fill(dp,-1);
        int len = coins.length;
        int max = coins[0];
        //初始化dp数组，dp[i]表示金额i的最优解
        for(int i = 1; i < amount+1; i++){
            for(int j = 0; j < len; j++){
                if(i == coins[j]){
                    dp[i] = 1;
                }
            }

        }
        dp[0] = 0;
        for(int i = 1; i < amount+1; i++){
            for(int j = 0; j < len; j++){
                if(i-coins[j] >= 0 && dp[i-coins[j]]!=-1){
                    if (dp[i]== -1 || dp[i] > dp[i - coins[j]] + 1){
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        
        return dp[amount];
    }

}
