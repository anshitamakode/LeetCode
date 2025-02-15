class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k=0;
        int n = nums1.length;
        int m = nums2.length;
        int p = m+n;
        int ans[] = new int[p];
        while(i<n && j<m){
            if(nums1[i] < nums2[j])
                ans[k++] = nums1[i++];
            else
                ans[k++] = nums2[j++];
        }
        while(i<n){
            ans[k++] = nums1[i++];
        }
        while(j<m){
            ans[k++] = nums2[j++];
        }
        if(p % 2 != 0)
            return (double)ans[p/2];
        else
            return (double)(ans[p/2] + ans[(p-1)/2])/2;
    }
}