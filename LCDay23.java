import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<int[]>();
        int i=0,j=0;
        while(i < A.length && j < B.length)
        {
            int maxStart = Math.max(A[i][0],B[j][0]);
            int minEnd = Math.min(A[i][1],B[j][1]);
            if(maxStart <= minEnd)
                list.add(new int[]{maxStart,minEnd});
            if(A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        int a[][] = new int[list.size()][2];
        i=0;
        for(int[] ar:list)
        {
            a[i++] = ar;
        }
        return a;
    }
	public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	Solution sol = new Solution();
    	int A[][] = new int[4][2];
    	int B[][] = new int[4][2];
    	for(int i=0;i<4;i++)
    		for(int j=0;j<2;j++)
    			A[i][j] = sc.nextInt();
    	for(int i=0;i<4;i++)
    		for(int j=0;j<2;j++)
    			B[i][j] = sc.nextInt();
    	int a[][] = sol.intervalIntersection(A, B);
    	for(int i=0;i<a.length;i++)
    		for(int j=0;j<2;j++)
    			System.out.println(a[i][j]);
    }
}