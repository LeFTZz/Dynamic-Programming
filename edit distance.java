class Solution {
    public int minDistance(String word1, String word2) {
        //要考虑空字符串，不然下面dp数组会有index错误
        if(word1.length() == 0){
            //System.out.println("aaaaa");
            return word2.length();
            
        }
        if(word2.length() == 0){
            //System.out.println("bbbbb");
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        //System.out.println(m);
        int[][] dp = new int[m+1][n+1];
        //初始化dp
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                dp[i][j] = 0;
            }
            
        }
        //边界值设定
        for(int i = 0; i<=n; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i<=m; i++){
            dp[i][0] = i;

        }
        //动态规划
        for(int i = 1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                //System.out.println(dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
