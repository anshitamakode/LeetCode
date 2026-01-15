class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*int i=0,j=0;
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
            return (ans[k/2] + ans[k/2 -1])/2;*/
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 < n1)
            return findMedianSortedArrays(nums2, nums1);
        int total = (n1+n2+1)/2;
        int n = n1+n2;
        int l = 0, h = n1;
        while(l<=h){
            int mid1 = (l+h)/2;
            int mid2 = total - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1-1 >= 0) l1=nums1[mid1-1];
            if(mid2-1 >= 0) l2=nums2[mid2-1];
            if(mid1<n1) r1=nums1[mid1];
            if(mid2<n2) r2=nums2[mid2];
            if(l1<=r2 && l2<=r1){
                if(n % 2 == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else
                    return Math.max(l1,l2);
            }
            if(l2 > r1){
                l = mid1+1;
            }
            else{
                h = mid1-1;
            }
        }
        return 0;
    }
}