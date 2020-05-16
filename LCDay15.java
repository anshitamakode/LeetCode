import java.util.Scanner;
class Solution{
	public int maxSubarraySumCircular(int[] A) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int curMax = 0;
		int curMin = 0;
		int total = 0;
		//this code is for non-circular array
		for(int i=0;i<A.length;i++)
		{
			//kadane's algorithm
			curMax = curMax + A[i];
			max = Math.max(curMax, max);
			curMax = Math.max(curMax, 0);
			//kadane's algorithm
			curMin = curMin + A[i];
			min = Math.min(curMin, min);
			curMin = Math.min(curMin, 0);
			
			total = total + A[i];
		}
		if(max<0)
			return max;
		//this code is for circular array
		return Math.max(max, total-min);
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int n = sc.nextInt();
		int a[] = new int[n];
		int max = sol.maxSubarraySumCircular(a);
		System.out.println(max);
	}
}