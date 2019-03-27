class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        int i,j;
        int dp_min;
        //初始化状态数组
        for(i = 0; i < row; i++){
            for(j = 0; j< col; j++)
                dp[i][j] = 0;
        }
        
        //从右下往左上，定义最后一个的值，即边界
        dp[row-1][col-1] = Math.max(1, 1 - dungeon[row-1][col-1]);
        //最下面一行,每个dp值由其右边的dp值和自己的dungeon值定义
        for(i = col - 2; i >= 0; i-- ){
            dp[row-1][i] = Math.max(1,dp[row-1][i+1] - dungeon[row-1][i]);
        }
        //最右边一列，每个每个dp值由其下边的dp值和自己的dungeon值定义
        for(i = row - 2; i >= 0; i--){
            dp[i][col-1] = Math.max(1,dp[i+1][col-1] - dungeon[i][col-1]);
        }
        //中间的，每个dp值是由右边或者下边的dp值与自己的dungeon值定义，右边或下边取min
        for(i = row - 2; i >= 0; i--){
            for(j = col - 2; j >= 0; j--){
                dp_min = Math.min(dp[i][j+1],dp[i+1][j]);
                dp[i][j] = Math.max(1,dp_min - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
