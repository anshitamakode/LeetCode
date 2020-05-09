import java.util.Scanner;
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        if(num == 1)
            return true;
        while(left<=right)
        {
        	long mid = left + (right - left)/2;
        	if((mid * mid) == num)
        		return true;
        	else if((mid * mid) < num)
        		left = mid + 1;
        	else
        		right = mid - 1;
        }
        return false;
    }
    public static void main(String args[])
    {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean b = sol.isPerfectSquare(n);
        System.out.println(b);
    }
}