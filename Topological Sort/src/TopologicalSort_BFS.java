import java.util.*;

public class TopologicalSort_BFS extends TopologicalSort{
    int []indegree;
    TopologicalSort_BFS(Map<Integer, List<Integer>> adjList) {
        super(adjList);
        this.indegree = new int[this.vertexCount];
        for(int i = 0; i < this.vertexCount; i++) {
            for(int v: this.adjList.get(i))
                this.indegree[v]++;
        }
    }


    void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < this.vertexCount; i++) {
            if(this.indegree[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int vertex = queue.remove();
                this.result.add(vertex);
                this.visited[vertex] = true;
        
                for(int v: this.adjList.get(vertex)) {
                    this.indegree[v]--;
                    if(this.indegree[v] == 0 && !this.visited[v])
                        queue.add(v);
                }
                
            }
        }
        print();
    
    }
    
}
