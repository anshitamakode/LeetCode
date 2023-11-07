class Solution {
    class Pair{
        long val;
        int index;
        Pair(long val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public int shortestSubarray(int[] nums, int k) {
        Deque<Pair> dq = new LinkedList<>();
        long sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(sum >= k){
                minLen = Math.min(minLen, i+1);
            }
            Pair p = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
            while(!dq.isEmpty() && sum - dq.peekFirst().val >= k){
                p = dq.peekFirst();
                dq.removeFirst();
            }
            if(p.val != Integer.MAX_VALUE){
                minLen = Math.min(minLen, i-p.index);
            }
            while(!dq.isEmpty() && dq.peekLast().val >= sum){
                dq.removeLast();
            }
            dq.addLast(new Pair(sum, i));
        }
        if(minLen == Integer.MAX_VALUE)
            return -1;
        return minLen;
    }
}