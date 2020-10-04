import java.util.*;

public abstract class TopologicalSort {
    Map<Integer, List<Integer>> adjList;
    int vertexCount;
    boolean []visited;
    List<Integer> result;

    TopologicalSort(Map<Integer, List<Integer>> adjList) {
        this.vertexCount = adjList.size();
        this.adjList = new HashMap<>(adjList);
        this.visited = new boolean[this.vertexCount];
        this.result = new ArrayList<>();
    }

    void clear() {
        Arrays.fill(this.visited, false);
        this.result.clear();
    }

    void print(){
        for(int i: this.result){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    abstract void topologicalSort();
}
