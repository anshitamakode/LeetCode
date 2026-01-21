class Solution {
    public long isPossible(int mid, int[] piles){
        long hour = 0;
        for(int i=0;i<piles.length;i++){
            int x = piles[i];
            if(x <= mid){
                hour++;
            }
            else{
                hour = hour + x/mid;
                if(x%mid != 0)
                    hour++;
            }
        }
        System.out.println(mid+" "+hour);
        return hour;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, piles[i]);
        }
        int low = 1, high = max;
        while(low<=high){
            int mid = (low+high)/2;
            long hour = isPossible(mid, piles);
            if(hour <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}