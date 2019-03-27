class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0){
            return 0;
        }
        //List<List<Integer>> dp = new ArrayList<>(triangle.size());
        
        
        //System.out.println(triangle.get(2).toArray()[0]);
          
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int i = 0; i < triangle.size(); i++){
            int jmax = i+1;
            for(int j = 0; j < jmax; j++){
                dp[i][j] = 0;
            }
        }
        
        for(int i = 0; i<dp.length; i++){
            int temp = (int)(triangle.get(dp.length-1).toArray()[i]);
            dp[dp.length-1][i] = temp;
        }
        for(int i = dp.length-2; i>=0;i--){
           // System.out.println(i);
           // System.out.println(i+1);
            for(int j = 0; j < i+1;j++){
                //System.out.println(j);
                //System.out.println(dp[i+1][j+1]);
                int temp = (int)(triangle.get(i).toArray()[j]);
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + temp;
            }
        }
        //System.out.println(Arrays.toString(dp[1]));
        
        return dp[0][0];
        
    }
}
