class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        double[] ans = new double[l1+l2];
        int k = 0;
        while(i<l1 && j<l2){
            if(nums1[i] < nums2[j]){
                ans[k++] = nums1[i++];
            }
            else{
                ans[k++] = nums2[j++];
            }
        }
        while(i<l1){
            ans[k++] = nums1[i++];
        }
        while(j<l2){
            ans[k++] = nums2[j++];
        }
        if(k%2 != 0)
            return ans[k/2];
        else
            return (ans[k/2] + ans[k/2 -1])/2;
    }
}