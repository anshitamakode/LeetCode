class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public void helper(int[] nums, int index, List<Integer> list){
        output.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++){ 
            if(i > index && nums[i] == nums[i-1]) 
                continue;
            list.add(nums[i]);
            helper(nums, i+1, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return output;
    }
}