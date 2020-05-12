import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class Solution {
    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
        	if(entry.getValue() == 1)
        		return entry.getKey();
        }
        return -1;
    }
    public static void main(String args[])
    {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int a[] = new int[l];
        for(int i=0;i<l;i++)
            a[i] = sc.nextInt();
        int n = sol.singleNonDuplicate(a);
        System.out.println(n);
    }
    
}