class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = Integer.MIN_VALUE;
        for(int i=0,j=0;i < n && j < n;j++){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                while(set.contains(c)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(c);
            }
            ans = Math.max(ans, j - i + 1);
        }
        if(ans == Integer.MIN_VALUE)
            return 0;
        return ans;
    }
}