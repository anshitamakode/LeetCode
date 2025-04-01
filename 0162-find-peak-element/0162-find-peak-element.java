class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, h = n-1;
        while(l <= h){
            int mid = (l+h)/2;
            if((mid - 1 < 0 || nums[mid-1] < nums[mid]) && (mid + 1 >= n || nums[mid+1] < nums[mid])){
                return mid;
            }
            else if(mid - 1 < 0 || nums[mid-1] < nums[mid]){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return 0;
    }
}