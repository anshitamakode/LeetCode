class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxR = Integer.MIN_VALUE;
        int maxL = Integer.MIN_VALUE;
        int[] Rmax = new int[n];
        int[] Lmax = new int[n];
        for(int i=n-1;i>=0;i--){
            Rmax[i] = Math.max(maxR, height[i]);
            maxR = Rmax[i];
        }
        for(int i=0;i<n;i++){
            Lmax[i] = Math.max(maxL, height[i]);
            maxL = Lmax[i];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int val = Math.min(Rmax[i], Lmax[i]) - height[i];
            if(val > 0)
                ans = ans + val;
        }
        return ans;
    }
}