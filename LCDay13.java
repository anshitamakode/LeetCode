import java.util.Scanner;
import java.util.Stack;
class Solution {
    public String removeKdigits(String num, int k) {
    	if(k==0)
    		return num;
    	if(k == num.length())
    		return "0";
    	Stack<Character> st = new Stack<Character>();
    	for(int i=0;i<num.length();i++)
    	{
    		char c = num.charAt(i);
    		while(!st.empty() && k>0 && st.peek()>c)
    		{
    			st.pop();
    			k--;
    		}
    		st.push(c);
    	}
    	for(int i=0;i<k;i++)
    		st.pop();
    	StringBuilder sb = new StringBuilder();
    	while(!st.empty())
    		sb.append(st.pop());
    	sb.reverse();
    	while(sb.length()>1 && sb.charAt(0) == '0')
    		sb.deleteCharAt(0);
    	return sb.toString();
    	
                   
    }
    public static void main(String args[])
    {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        String str = sol.removeKdigits(s,k);
        System.out.println(str);
    }
}