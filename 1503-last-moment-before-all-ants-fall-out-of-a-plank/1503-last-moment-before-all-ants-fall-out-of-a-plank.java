class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0;i<left.length;i++){
            tree.add(left[i]);
        }
        for(int i=0;i<right.length;i++){
            tree.add(n - right[i]);
        }
        return tree.last();
    }
}