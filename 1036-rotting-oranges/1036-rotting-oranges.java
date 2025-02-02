public class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                vis[i][j] = -1;
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j));
                    vis[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int i = p.i;
            int j = p.j;
            int[] x = {-1,1,0,0};
            int[] y = {0,0,-1,1};
            for(int k=0;k<4;k++){
                int newi = i + x[k];
                int newj = j + y[k];
                if(newi >=0 && newi < n && newj >=0 && newj < m && vis[newi][newj] == -1 && grid[newi][newj] == 1){
                    queue.add(new Pair(newi, newj));
                    vis[newi][newj] = vis[i][j] + 1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && vis[i][j] == -1)
                    return -1;
                max = Math.max(vis[i][j], max);
            }
        }
        return max;
    }
}