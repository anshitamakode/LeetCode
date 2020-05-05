
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        char c = ' ';
        for(int i=0;i<s.length();i++)
        {
        	c = s.charAt(i);
        	map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
        	c = s.charAt(i);
        	if(map.get(c)  == 1)
        		return i;
        }
        
        return -1;
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        String s = sc.next();
        int n = sol.firstUniqChar(s);
        System.out.println(n);
    }
}