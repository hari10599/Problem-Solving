import java.util.*;

public class Main {
    public static void main(String[] args) {
        int vertexCount = 6;
        int [][]edges = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < vertexCount; i++)
            adjList.put(i, new ArrayList<Integer>());
        for(int []i: edges) 
            adjList.get(i[0]).add(i[1]);
        
        TopologicalSort ts = new TopologicalSort_BFS(adjList);
        ts.topologicalSort();

        
    }
}
