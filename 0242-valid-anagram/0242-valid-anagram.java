class Solution {
    public boolean isAnagram(String s, String t) {
        int[] shash = new int[26];
        int[] thash = new int[26];
        for(int i=0;i<s.length();i++){
            shash[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<t.length();i++){
            thash[t.charAt(i) - 'a']++;
        }
        if(Arrays.equals(shash, thash))
            return true;
        return false;
    }
}