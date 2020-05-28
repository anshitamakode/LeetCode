import java.util.Scanner;
class Solution {
	public int[] countBits(int num) {
		int count[] = new int[num+1];
		for(int i=0;i<=num;i++)
		{
			if(i%2 == 0)
				count[i] = count[i/2];
			else
				count[i] = count[i/2] + 1;
		}
		return count;
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Solution sol = new Solution();
		int num = sc.nextInt();
		int b[] = sol.countBits(num);
		for(int i=0;i<b.length;i++)
			System.out.println(b[i]);
		
	}
}