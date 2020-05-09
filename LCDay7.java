import java.util.Scanner;
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
    	if(coordinates.length == 0)
    		return false;
    	double x1 = coordinates[0][0];
    	double y1 = coordinates[0][1];
    	Double slope = null;
    	for(int i=1;i<coordinates.length;i++)
    	{
    		double x2 = coordinates[i][0];
    		double y2 = coordinates[i][1];
    		
    		if(x2-x1 == 0)
    			return false;
    		if(slope == null)
    		{
    			slope = (y2-y1)/(x2-x1);
    			continue;
    		}
    		double slope2 = (y2-y1)/(x2-x1);
    		if(slope!=slope2)
    			return false;
    	}
    	return true;
    	
        
    }

    public static void main(String args[])
    {
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int a[][] = new int[x][2];
        for(int i=0;i<x;i++)
            for(int j=0;j<2;j++)
                a[i][j] = sc.nextInt();
        boolean c = sol.checkStraightLine(a);
        System.out.println(c);
    }
}