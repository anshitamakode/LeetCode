import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
class Solution {
    public int numJewelsInStones(String J, String S) {
    	int count = 0;
    	char ar[] = new char[J.length()];
    	char ar1[] = new char[S.length()];
    	for(int i=0;i<J.length();i++)
    		ar[i] = J.charAt(i);
    	HashSet<Character> set = new HashSet<Character>();
    	for(int j=0;j<S.length();j++)
    	{
    		ar1[j] = S.charAt(j);
    		set.add(ar1[j]);
    	}
    	for(int k=0;k<=J.length();k++)
    	{
    		if(set.contains(ar[k]))
    		{
    			set.remove(ar[k]);
    			count++;
    		}
    		if(k == J.length())
    			k=0;
    			
    			
    	}
    	return count;
    }
    public static void main(String args[])
    {
    	Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        String J = sc.next();
        String S = sc.next();
        int no = s.numJewelsInStones(J, S);
        System.out.println(no);
    }
}