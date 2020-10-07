import java.util.*;

public class TopologicalSort_ALL extends TopologicalSort{
    int []indegree;
    TopologicalSort_ALL(Map<Integer, List<Integer>> adjList) {
        super(adjList);
        this.indegree = new int[this.vertexCount];
        for(int i = 0; i < this.vertexCount; i++) {
            for(int v: this.adjList.get(i))
                this.indegree[v]++;
        }
    } 

    void topologicalSort() {
        List<Integer> curr = new ArrayList<>();
        allTopologicalSort(curr, this.indegree);
    }

    void allTopologicalSort(List<Integer> curr, int []indegree) {
        for(int i = 0; i < vertexCount; i++) {
            if(visited[i] == 0 && indegree[i] == 0) {
                curr.add(i);
                visited[i] = 1;
                for(int v: this.adjList.get(i))  
                    indegree[v]--;
                allTopologicalSort(curr, indegree);
                curr.remove(curr.size()-1);
                visited[i] = 0;
                for(int v: this.adjList.get(i))
                    indegree[v]++;
            }
        }
        if(curr.size() == vertexCount) {
            for(int i: curr)
                System.out.print(i+" ");
            System.out.println();
        }
    }

}
