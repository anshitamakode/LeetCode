import java.util.HashMap;
import java.util.Scanner;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i=0;i<magazine.length();i++)
    	{
    		char ch = magazine.charAt(i);
    		map.put(ch,map.getOrDefault(ch,0)+1);
    	}
    	for(int i=0;i<ransomNote.length();i++)
    	{
    		char ch = ransomNote.charAt(i);
    		if(!map.containsKey(ch) || map.get(ch)<=0)
    			return false;
    		map.put(ch,map.get(ch)-1);
    	}
    	return true;
    }
    public static void main(String args[])
    {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        String rn = sc.next();
        String mg = sc.next();
        boolean yn = s.canConstruct(rn,mg);
        System.out.println(yn);
    }
}
