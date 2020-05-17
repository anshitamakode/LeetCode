import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> l = new ArrayList<Integer>();
		if(s.length() == 0 || s == null)
			return l;
		int char_count[] = new int[26];
		for(char c : p.toCharArray())
			char_count[c - 'a']++;
		int right = 0;
		int left = 0;
		int count = p.length();
		while(right < s.length())
		{
			if(char_count[s.charAt(right++)-'a']-- >=1)
				count--;
			if(count == 0)
				l.add(left);
			if(right - left == p.length() && char_count[s.charAt(left++)-'a']++ >=0)
				count++;
		}
		return l;
	}
	public static void main(String args[])
	{
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String s1 = sc.next();
		List<Integer> l = sol.findAnagrams(s,s1);
		System.out.println(l);
	}
}