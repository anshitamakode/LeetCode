class Solution {
    public int countOfGas(double mid, int[] stations) {
        int cnt = 0;
        for (int i = 1; i < stations.length; i++) {
            int numberInBet = (int) ((stations[i] - stations[i-1]) / mid);
            if ((stations[i] - stations[i-1]) == numberInBet * mid) {
                numberInBet--;
            }
            cnt += numberInBet;
        }
        return cnt;
    }
    
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double low = 0, high = 0;
        
        for (int i = 1; i < n; i++) {
            high = Math.max(high, stations[i] - stations[i-1]);
        }
        
        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            int cnt = countOfGas(mid, stations);
            if (cnt <= k) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }
}