import java.util.Scanner;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	int color = image[sr][sc];
    	if(color != newColor)
    		helper(image, sr, sc, newColor, color);
        return image;
    }
    public void helper(int[][] image, int i, int j, int newColor,int color)
    {
    	if(i<0 || i>=image.length || j<0 || j>= image[0].length || image[i][j]!=color) {
    		return;
    	}
    	image[i][j] = newColor;
    	helper(image, i+1, j, newColor,color);
    	helper(image, i-1, j, newColor,color);
    	helper(image, i, j+1, newColor,color);
		helper(image, i, j-1, newColor,color);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int image[][] = new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                image[i][j] = sc.nextInt();
        int sr = sc.nextInt();
        int scol = sc.nextInt();
        int newColor = sc.nextInt();
        int img[][] = sol.floodFill(image,sr,scol,newColor);
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                System.out.print(img[i][j]+" ");
            System.out.println();
        }
    }
}