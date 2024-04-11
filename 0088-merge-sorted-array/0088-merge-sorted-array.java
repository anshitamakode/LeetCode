class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1;
        int k = m + n -1;
        if(nums1.length == nums2.length){
            i = n-1;
        }
        while(i >= 0 && j >= 0){
            if(nums1.length == nums2.length){
                nums1[i] = nums2[j];
                i--;
                j--;
            }
            else if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                nums1[i] = 0;
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}