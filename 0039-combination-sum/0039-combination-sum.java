class Solution {
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        helper(candidates, target, 0, new ArrayList<Integer>(), n);
        return output;
    }
    public void helper(int[] candidates, int target, int index, List<Integer> list, int n){
        if(target == 0){
            output.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || index == n)
            return;
        list.add(candidates[index]);
        helper(candidates, target-candidates[index], index, list, n);
        list.remove(list.size()-1);
        helper(candidates, target, index+1, list, n);
    }
}