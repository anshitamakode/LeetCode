import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		StringBuilder res = new StringBuilder();
		for(char c:s.toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a,b) -> map.get(b) - map.get(a));// eert
		//PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(Collections.reverseOrder()); tree
		//PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(); eert
		maxHeap.addAll(map.keySet());
		while(!maxHeap.isEmpty()) {
			char curr = maxHeap.remove();
			for(int i=0;i<map.get(curr);i++)
				res.append(curr);
		}
		return res.toString();
	
	}
	public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	Solution sol = new Solution();
    	String s = sc.next(); // tree
    	String s1 = sol.frequencySort(s);
    	System.out.println(s1); //eert
    }
}