/*class Solution {
    public int helper(int first, int second, int[] cuts, int cutsLength, int[][] dp){
        if(dp[first][second] != -1) return dp[first][second];
        int l = second - first;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cutsLength;i++){
            if(cuts[i] > first && cuts[i] < second){ 
                int cost = l + helper(first, cuts[i], cuts, cutsLength, dp)
                                + helper(cuts[i], second, cuts, cutsLength, dp);
                min = Math.min(min, cost);
            }
        }
        dp[first][second] = (min == Integer.MAX_VALUE) ? 0 : min;
        return dp[first][second];
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(0, n, cuts, cuts.length, dp);
    }
}*/
class Solution {
    HashMap<String, Integer> dp = new HashMap<>();
    
    public int helper(int first, int second, int[] cuts, int cutsLength){
        String key = first + "," + second;
        if(dp.containsKey(key)) return dp.get(key);
        
        int l = second - first;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cutsLength;i++){
            if(cuts[i] > first && cuts[i] < second){ 
                int cost = l + helper(first, cuts[i], cuts, cutsLength)
                                + helper(cuts[i], second, cuts, cutsLength);
                min = Math.min(min, cost);
            }
        }
        int result = (min == Integer.MAX_VALUE) ? 0 : min;
        dp.put(key, result);
        return result;
    }
    
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        return helper(0, n, cuts, cuts.length);
    }
}