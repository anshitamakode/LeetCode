/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import java.util.Scanner;

public class Solution extends VersionControl {
    
     public int firstBadVersion(int version){
    	int start = 1;
    	int end = version;
    	while(start<end)
    	{
    		int mid = start + (end-start)/2;
    		if(isBadVersion(mid))
    			end = mid;
    		else
    			start = mid + 1;
    	}
    	return start;
    }
    	
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        int ver = sc.nextInt();
        int no = s.firstBadVersion(ver);
        System.out.println(no+" is a first bad version");
    }
}