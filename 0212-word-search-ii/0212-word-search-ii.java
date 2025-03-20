class Trie{
    String value;
    Trie[] child;
    Boolean end;
    Trie(String value){
        this.value = value;
        child = new Trie[26];
    }
}
class Solution {
    public Set<String> ansSet = new HashSet<>();
    public void addWordinTrie(Trie root, String s){
        Trie cur = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(cur.child[c-'a'] == null){
                cur.child[c-'a'] = new Trie(null);
            }
            cur = cur.child[c-'a'];
        }
        cur.value = s;
    }
    public void dfs(char[][] board, Trie root , StringBuilder sb, int i, int j, int n, int m, boolean[][] visited){
        if(i >= n || j >= m || i < 0 || j < 0 || visited[i][j])
            return;
        char c = board[i][j];
        if (root.child[c - 'a'] == null) return;
        visited[i][j] = true;
        sb.append(c);
        root = root.child[c - 'a'];
        if (root.value != null) {
            ansSet.add(root.value);
            root.value = null;
        }
        dfs(board, root, sb, i+1, j, n, m, visited);
        dfs(board, root, sb, i, j+1, n, m, visited);
        dfs(board, root, sb, i-1, j, n, m, visited);
        dfs(board, root, sb, i, j-1, n, m, visited);
        sb.deleteCharAt(sb.length()-1);
        visited[i][j] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
    int n = board.length;
    int m = board[0].length;
    Trie root = new Trie(null);
    StringBuilder sb = new StringBuilder();
    boolean[][] visited = new boolean[n][m];
    for(String word : words) {
        addWordinTrie(root, word);
    }
    for(int i=0;i<n;i++)
        Arrays.fill(visited[i], false);
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(!visited[i][j])
                dfs(board, root, sb, i, j, n, m, visited);
        }
    }
    return new ArrayList<>(ansSet);
    }
    
}