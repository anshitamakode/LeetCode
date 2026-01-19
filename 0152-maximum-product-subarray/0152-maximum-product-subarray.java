class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int pre = 1, suff=1;
        for(int i=0;i<n;i++){
            if(pre == 0)
                pre=1;
            if(suff == 0)
                suff=1;
            pre = pre*nums[i];
            suff = suff*nums[n-i-1];
            max = Math.max(max, pre);
            max = Math.max(max, suff);
        }
        return max;
    }
}