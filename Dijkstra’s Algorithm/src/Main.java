import java.util.*;

public class Main {

    public static void dijkstra(int startVertex, int vertexCount, Map<Integer, List<Node>> adjList) {
        MinHeap_Map minheap = new MinHeap_Map();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        for(int i = 0; i < vertexCount; i++) {
            if(i == startVertex)
                minheap.addVertex(i, 0);
            else
                minheap.addVertex(i, Integer.MAX_VALUE);
        }
        parent.put(startVertex, null);
        while(!minheap.heap.isEmpty()) {
            //minheap.print();
            List<Integer> min = minheap.extractMin();
            int currentVertex = min.get(0);
            int currentWeight = min.get(1);
            distance.put(currentVertex, currentWeight);
            for(Node n: adjList.get(currentVertex)) {
                int newWeight = currentWeight + n.weight;
                if(!minheap.position.containsKey(n.vertex))
                    continue;
                if(minheap.getWeight(n.vertex) > newWeight) {
                    minheap.decreaseKey(n.vertex, newWeight);
                    parent.put(n.vertex, currentVertex);
                }
            }
            //System.out.println(distance);
            //System.out.println("*****");
        }
        System.out.println(distance);

    }


    public static void main(String[] args) throws Exception {
        int vertexCount = 9;
        int startVertex = 0;
        Map<Integer, List<Node>> adjList = new HashMap<>();
        int [][] edges = {{0, 1, 4}, {0, 7, 8},{1,2,8},{1,7,11},{2,3,7},{2,8,2},{2,5,4},{3,4,9},{3,5,14},
                            {4,5,10},{5,6,2},{6,7,1},{6,8,6},{7,8,7}};
        for(int i = 0; i < vertexCount; i++)
            adjList.put(i, new ArrayList<>());
        for(int []e: edges) {
            adjList.get(e[0]).add(new Node(e[1], e[2]));
            adjList.get(e[1]).add(new Node(e[0], e[2]));
        }
        dijkstra(startVertex, vertexCount, adjList);
        
    }
}
