class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    public void helper(int[] candidates, int target, List<Integer> list, int s){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(s == candidates.length || target < 0)
            return;
        for(int i=s;i<candidates.length;i++){
            if(i != s && candidates[i] == candidates[i-1]) 
                continue;
            int num = candidates[i];
            list.add(num);
            helper(candidates, target - num, list, i+1);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0);
        return ans;
    }
}