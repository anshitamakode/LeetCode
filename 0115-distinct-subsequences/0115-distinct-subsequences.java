class Solution {
    public int result = 0;
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++)
            Arrays.fill(dp[i], -1);
        return helper(s, t, 0, 0, dp);
    }
    public int helper(String s, String t, int i, int j, int[][] dp){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = helper(s, t, i+1, j+1, dp) + helper(s, t, i+1, j, dp);
        }
        else{
            dp[i][j] = helper(s, t, i+1, j, dp);
        }
        return dp[i][j];
    }
}