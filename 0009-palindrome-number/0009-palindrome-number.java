class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length-1;
        while(i < j){
            char c1 = arr[i];
            char c2 = arr[j];
            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}