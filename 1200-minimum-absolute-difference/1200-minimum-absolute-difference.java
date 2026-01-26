class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<n;i++){
            int x = arr[i-1];
            int y = arr[i];
            int d = Math.abs(y-x);
            min = Math.min(min, d);
        }
        for(int i=1;i<n;i++){
            int x = arr[i-1];
            int y = arr[i];
            int d = Math.abs(y-x);
            if(min == d){
                List<Integer> list = new ArrayList<>();
                if(x < y){
                    list.add(x);
                    list.add(y);
                }
                else{
                    list.add(y);
                    list.add(x);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}