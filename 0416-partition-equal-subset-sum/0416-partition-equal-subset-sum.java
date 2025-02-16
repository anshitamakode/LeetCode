class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x : nums){
            sum = sum + x;
        }
        if(sum % 2 != 0){
            return false;
        }
        sum = sum/2;
        int[][] dp = new int[n][sum+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);
        return helper(nums, sum, 0, n, dp);
    }
    public boolean helper(int[] nums, int sum, int i, int n, int[][] dp){
        if(sum == 0)
            return true;
        if(i == n || sum < 0)
            return false;
        if(dp[i][sum] != -1) return dp[i][sum] == 1 ? true : false;
        boolean res = helper(nums, sum - nums[i], i+1, n, dp) || helper(nums, sum, i+1, n, dp);
        dp[i][sum] = res ? 1 : 0;
        return res;
    }
}