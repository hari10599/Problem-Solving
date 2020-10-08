import java.time.chrono.MinguoEra;
import java.util.*;

public class Main {

    public static void dijkstra(int startVertex, int vertexCount, Map<Integer, List<Edge>> adjList) {

    }


    public static void main(String[] args) throws Exception {
        int vertexCount = 9;
        int startVertex = 0;
        Map<Integer, List<Edge>> adjList = new HashMap<>();
        int [][] edges = {{0, 1, 4}, {0, 7, 8},{1,2,8},{1,7,11},{2,3,7},{2,8,2},{2,5,4},{3,4,9},{3,5,14},
                            {4,5,10},{5,6,2},{6,7,1},{6,8,6},{7,8,7}};
        for(int i = 0; i < vertexCount; i++)
            adjList.put(i, new ArrayList<>());
        for(int []e: edges)
            adjList.get(e[0]).add(new Edge(e[1], e[2]));
        dijkstra(startVertex, vertexCount, adjList);
        
    }
}
