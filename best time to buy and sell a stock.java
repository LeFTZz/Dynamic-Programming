class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int[] dp = new int[prices.length];
        int i;
        //初始化dp
        for (i = 0; i<prices.length;i++){
            dp[i] = 0;
        }
        //边界值
        dp[0] = 0;
        //状态转移方程
        int max = 0;
        for(i = 1; i < prices.length; i++){
            int dif = prices[i] - prices[i-1];
            dp[i] = dp[i-1] + dif;
            if(dp[i]<0) dp[i]=0; //盈利不能为负数
            if(dp[i] > max) max = dp[i];
            
        }
        return max;
    }
    
}
