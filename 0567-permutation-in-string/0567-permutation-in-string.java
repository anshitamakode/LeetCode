class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
       if (n > m || m == 0) 
           return false;
        if (n == 0) 
            return true;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i=0;i<n;i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        for(int i=n;i<m;i++) {
            if(Arrays.equals(arr1, arr2))
                return true;
            arr2[s2.charAt(i-n) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(arr1, arr2)) 
            return true;
        else 
            return false;
    }
}