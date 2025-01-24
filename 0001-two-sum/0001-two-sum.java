class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int curr = nums[i];
            int diff = target - curr;
            if(!map.containsKey(diff)){
                map.put(curr, i);
            }
            else{
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}