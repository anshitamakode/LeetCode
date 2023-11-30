class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int n = people.length;
        int i = 0, j = n-1;
        while(i <= j) {
            int sum = people[i] + people[j];
            if(sum <= limit){
                i++;
            }
            cnt++;
            j--;
        }
        return cnt;
    }
}