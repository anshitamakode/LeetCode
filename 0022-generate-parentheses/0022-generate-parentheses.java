class Solution {
    public List<String> output = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, new StringBuilder());
        return output;
    }
    public void helper(int n, int open, int close, StringBuilder sb){
        if(open == close && open == n){
            output.add(new StringBuilder(sb).toString());
            return;
        }
        if(open < n){
            sb.append("(");
            helper(n, open+1, close, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            helper(n, open, close+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}