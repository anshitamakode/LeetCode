class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0, j=0;
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;
        while(j < n){
            sum = sum + nums[j];
            if(sum >= target){
                while(sum >= target){
                    sum = sum - nums[i];
                    i++;
                }
                minLen = Math.min(minLen, j-i+2);
            }
            j++;
        }
        if(minLen == Integer.MAX_VALUE)
            return 0;
        return minLen;
    }
}