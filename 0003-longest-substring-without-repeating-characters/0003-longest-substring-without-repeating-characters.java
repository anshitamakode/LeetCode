class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0, n = s.length();
        while (j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}