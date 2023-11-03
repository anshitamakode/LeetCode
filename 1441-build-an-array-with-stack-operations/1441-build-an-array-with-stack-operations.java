class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int k=0;
        int m = target.length;
        for(int i=1;i<=n && k<m;i++){
            list.add("Push");
            if(i != target[k]){
                list.add("Pop");
            }
            else{
                k++;
            }
        }
        return list;
    }
}