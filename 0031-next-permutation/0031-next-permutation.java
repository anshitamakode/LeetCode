class Solution {
    /*[1,2,3]
    [1,3,2] [1,2,3]
    [2,1,3]
    [2,3,1] [2,1,3]
    [3,1,2]
    [3,2,1]*/
    public void reverse(int[] nums, int s, int n){
        while(s<n-1){
            int temp = nums[s];
            nums[s] = nums[n-1];
            nums[n-1] = temp;
            s++;
            n--;
        }
    }
    public int smallestEleGreaterThanPivot(int[] nums, int pivotVal, int pivot, int n){
        int val = Integer.MAX_VALUE;
        int s = 0;
        for(int i=pivot+1;i<n;i++){
            if(nums[i] < val && nums[i] > pivotVal){
                val = nums[i];
                s = i;
            }
        }
        return s;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1)
            reverse(nums, 0, n);
        else{
            reverse(nums, pivot+1, n);
            int s = smallestEleGreaterThanPivot(nums, nums[pivot], pivot, n);
            int temp = nums[s];
            nums[s] = nums[pivot];
            nums[pivot] = temp;
        }
    }
}