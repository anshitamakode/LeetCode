class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] Lmax = new int[n];
        int[] Rmax = new int[n];
        Rmax[n-1] = height[n-1];
        int right = height[n-1];
        for(int i=n-2;i>=0;i--){
            right = Math.max(height[i], right);
            Rmax[i] = right;
        }
        Lmax[0] = height[0];
        int left = height[0];
        for(int i=1;i<n;i++){
            left = Math.max(height[i], left);
            Lmax[i] = left;
        }
        int total = 0;
        for(int i=0;i<n;i++){
            int ans = Math.min(Rmax[i], Lmax[i]) - height[i];
            if(ans > 0){
                total = total + ans;
            }
        }
        return total;
    }
}