import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Solution {
    public int findJudge(int N, int[][] trust) {
    	if(N==1)
    		return N;
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	for(int[] record:trust)
    	{
    		int a = record[0];
    		int b = record[1];
    		List<Integer> li = map.get(a);
    		if(li == null)
    			li = new ArrayList<>();
    		li.add(b);
    		map.put(a,li);
    	}
    	Map<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
    	for(List<Integer> count : map.values())
    	{
    		for(Integer value : count)
    			mapCount.put(value,mapCount.getOrDefault(value, 0)+1);
    	}
    	for(Integer i : mapCount.keySet())
    	{
    		if(mapCount.get(i) == N-1 && !map.containsKey(i))
    			return i;
    	}
    	return -1;
    	
    }
    public static void main(String args[])
    {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
       // int r = sc.nextInt();
        int a[][] = new int[2][2];
        for(int i=0;i<2;i++)
            for(int j=0;j<2;j++)
            	a[i][j] = sc.nextInt();
        int n = sol.findJudge(N,a);
        System.out.println(n);
    }
}