class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();         
        List<List<Integer>> ans = new ArrayList<>();               
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x = j+1, y = n-1;
                long w = nums[i] + nums[j];
                long val = target - w; 
                while(x < y){
                    long sum = nums[x] + nums[y];
                    if(sum > val){
                        y--;
                    }
                    else if(sum < val){
                        x++;
                    }
                    else{
                        List<Integer> lst = new ArrayList<>();
                        lst.add(nums[i]);
                        lst.add(nums[j]);
                        lst.add(nums[x]);
                        lst.add(nums[y]);
                        set.add(lst);  
                        y--;
                        x++;
                    }
                }
            }
        }
        for(List<Integer> list : set){
            ans.add(list);
        }
        /*Map<Integer, Pair> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                long sum = nums[i]+nums[j];
                map.put((int)sum, new Pair(i, j));
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                long val = nums[i] + nums[j];
                long w = target - val;
                if(map.containsKey((int)w)){
                    Pair p = map.get(w);
                    if(i != p.i && j != p.j && i != p.j && j != p.i){
                        List<Integer> lst = Arrays.asList(i, j, p.i, p.j);
                        set.add(lst);
                    }
                }
            }
        }
        for(List<Integer> list : set){
            ans.add(list);
        }*/
        return ans;
    }
}