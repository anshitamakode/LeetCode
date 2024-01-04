class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        int i = 0, j = -1;
        int left = -1, right = -1; 
        int minLen = Integer.MAX_VALUE;
        while (j < s.length()) {
            j++;
            if(j < s.length() && tmap.containsKey(s.charAt(j))) {
                smap.put(s.charAt(j), smap.getOrDefault(s.charAt(j), 0) + 1);
            }
            while(check(smap, tmap) && i <= j) {
                if(j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    left = i;
                    right = i + minLen;
                }
                if(tmap.containsKey(s.charAt(i))) {
                    smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) - 1);
                }
                i++;
            }
        }
        return left == -1 ? "" : s.substring(left, right);
    }
    public boolean check(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for(Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            char ch = entry.getKey();
            int val = entry.getValue();
            if(smap.getOrDefault(ch, 0) < val) {
                return false;
            }
        }
        return true;
    }
}