class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        String output = "";
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '(') 
                st.add(i);
            if (sb.charAt(i) == ')') 
            {
              if (!st.empty()) 
                  st.pop();
              else 
                  sb.setCharAt(i, '*');
            }
        }
         while(!st.empty())
            sb.setCharAt(st.pop(), '*');
        output = sb.toString().replaceAll("\\*", "");
        return output;
    }
}