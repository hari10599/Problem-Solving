import java.util.*;

public class TopologicalSort_DFS extends TopologicalSort{
    TopologicalSort_DFS(Map<Integer, List<Integer>> adjList) {
        super(adjList);
    } 

    void topologicalSort() {
        Stack<Integer> result = new Stack<>();

        for(int i = 0; i < this.vertexCount; i++) {
            if(this.visited[i] == 0)
                dfs(i, result);
        }
        while(!result.isEmpty())
            this.result.add(result.pop());
        print();
    }

    void dfs(int vertex, Stack<Integer> result) {
        if(this.visited[vertex] == 2)
            return;

        this.visited[vertex] = 1;
        for(int v : this.adjList.get(vertex)) {
            if(this.visited[v] != 2) {
                dfs(v, result);
            }
        }
        if(this.visited[vertex] != 2)
            result.add(vertex);

        this.visited[vertex] = 2;
    }

    
    
}
