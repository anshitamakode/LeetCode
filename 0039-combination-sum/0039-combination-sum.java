class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public void helper(int[] candidates, int target, List<Integer> list, int s){
        if(s == candidates.length || target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=s;i<candidates.length;i++){
            int num = candidates[i];
            list.add(num);
            helper(candidates, target - num, list, i);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, new ArrayList<>(), 0);
        return ans;
    }
}