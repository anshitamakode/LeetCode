class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] curr: intervals){
            if(end >= curr[0]){
                end = Math.max(end, curr[1]);
            } 
            else{
                answer.add(new int[]{start,end});
                start = curr[0];
                end = curr[1];
            }
        }
        answer.add(new int[]{start,end}); 
        return answer.toArray(new int[answer.size()][]); 
    }
}