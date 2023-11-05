class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        int w = arr[0];
        for(int i=1;i<n && cnt<k;i++){
            if(w > arr[i]){
                cnt++;
            }
            else{
                w = arr[i];
                cnt = 1;
            }
        }
        return w;
    }
}