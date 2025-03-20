class Solution {
    public boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int n, int m, int index){
        if(index == word.length()) return true;
        if(i >= n || j >= m || i < 0 || j < 0 || visited[i][j] || board[i][j] != word.charAt(index)) return false;
        visited[i][j] = true;
        boolean ans = dfs(board, word, i+1, j, visited, n, m, index+1) ||
        dfs(board, word, i, j+1, visited, n, m, index+1) || 
        dfs(board, word, i-1, j, visited, n, m, index+1) || 
        dfs(board, word, i, j-1, visited, n, m, index+1);
        visited[i][j] = false;
        return ans;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(visited[i], false);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j])
                    if(dfs(board, word, i, j, visited, n, m, 0)) return true;
            }
        }
        return false;
    }
}