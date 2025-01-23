class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = Math.abs(nums[i]);
            if(nums[x-1] < 0)
                list.add(x);
            nums[x-1] = nums[x-1] * -1;
        }
        return list;
    }
}