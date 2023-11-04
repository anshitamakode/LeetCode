class Solution {
    public List<List<String>> ans = new ArrayList<>();
    public boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void helper(String s, List<String> list, int i){
        if(s.length() == i){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<s.length();j++){
            String sub = s.substring(i, j+1);
            if(isPalindrome(sub)){
                list.add(sub);
                helper(s, list, j+1);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>(), 0);
        return ans;
    }
}