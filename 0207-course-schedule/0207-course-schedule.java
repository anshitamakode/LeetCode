class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adjList[] = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adjList[u].add(v);
            indegree[v]++;
        }
        //DFS

        /*int[] vis = new int[numCourses];
        int[] path = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(vis[i] == 0){
                if(dfs(adjList, vis, path, i) == true) return false;
            }
        }
        return true;*/

        //BFS

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int node = queue.remove();
            cnt++;
            for(int i=0;i<adjList[node].size();i++){
                int adjNode = adjList[node].get(i);
                indegree[adjNode]--;
                if(indegree[adjNode] == 0)
                    queue.add(adjNode);
            }
        }
        if(cnt == numCourses)
            return true;
        else
            return false;
    }
    public boolean dfs(List<Integer>[] adjList, int[] vis, int[] path, int i){
        vis[i] = 1;
        path[i] = 1;
        for(int j=0;j<adjList[i].size();j++){
            int node = adjList[i].get(j);
            if(vis[node] == 0){
                if(dfs(adjList, vis, path, node) == true){
                    return true;
                }
            }
            else if(path[node] == 1)
                return true;
        }
        path[i] = 0;
        return false;
    }
}