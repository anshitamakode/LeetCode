class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper("", list, n, n);
        return list;
    }
    public void helper(String substr, List<String> list, int open, int close){
        if(open > close){
            return;
        }
        if(open == 0 && close == 0){
            list.add(substr);
            return;
        }
        if(open > 0){
            helper(substr + "(" , list, open-1, close);
        }
        if(close > 0){
            helper(substr + ")" , list, open, close-1);
        }
    }
}