class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        String ans = "";
        int max = Integer.MIN_VALUE;
        for(int k=0;k<n;k++){
            for(int i=0,j=k;i<n&&j<n;i++,j++){
                if(i==j){
                    dp[i][j] = 1;
                }
                else if(k == 1){
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] != 0)
                        dp[i][j] = dp[i+1][j-1] + 2;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
}