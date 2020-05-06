import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Solution {
    public int majorityElement(int[] nums) {
    	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<nums.length;i++)
    	{
    		map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    	}
    	for(Map.Entry<Integer,Integer> entry:map.entrySet())
    	{
    		if(entry.getValue() > nums.length/2)
    			return entry.getKey();
    	}
    	return 0;
        
    }
    public static void main(String args[])
    {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int[] ar = new int[7];
        for(int i=0;i<ar.length;i++)
            ar[i] = sc.nextInt();
        int n = sol.majorityElement(ar);
        System.out.println(n);
    }
}