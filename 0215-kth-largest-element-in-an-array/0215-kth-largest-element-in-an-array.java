class Solution {
    public int partition(int l, int r, int[] nums){
        int p = l;
        l = l+1;
        System.out.println("l "+l+" r "+r+" p "+p);
        while(l <= r){
            if(nums[l] > nums[p] && nums[r] < nums[p]){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
            if(nums[l] <= nums[p]){
                l++;
            }
            if(nums[r] >= nums[p]){
                r--;
            }
        }
        int temp = nums[r];
        nums[r] = nums[p];
        nums[p] = temp;
        return r;
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int ans = 0;
        while(true){
            int p = partition(l, r, nums);
            if(p == n-k){
                ans = nums[p];
                break;
            }
            else if(p > n-k){
                r = p-1;
            }
            else{
                l = p+1;
            }
        }
        return ans;
    }
}