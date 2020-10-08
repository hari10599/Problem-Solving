import java.util.*;

public class MinHeap_Map {

    List<Node> heap;
    Map<Integer, Integer> position; //vertex(key) : position in heap list
    
    MinHeap_Map() {
        heap = new ArrayList<>();
        position = new HashMap<>();
    }

    int getRootNodeIndex(int index) {
        return index == 0 ? 0 : (index-1)/2;
    }

    int getLeftNodeIndex(int index) {
        return 2*index + 1;
    }

    int getRightNodeIndex(int index) {
        return 2*index + 2;
    }

    int getWeight(int vertex) {
        return heap.get(position.get(vertex)).weight;
    }

    void swap(Node n1, Node n2) {
        positionUpdate(n1.vertex, n2.vertex);
        int vertex = n1.vertex;
        int weight = n1.weight;

        n1.vertex = n2.vertex;
        n1.weight = n2.weight;

        n2.vertex = vertex;
        n2.weight = weight;
    }

    void positionUpdate(int v1, int v2) {
        int indexV1 = position.get(v1);
        int indexV2 = position.get(v2);

        position.put(v1, indexV2);
        position.put(v2, indexV1);
    }

    void addVertex(int vertex, int weight) {
        int index = heap.size();
        heap.add(new Node(vertex, weight));
        position.put(vertex, index);
        heapifyUp(index);
    }

    void heapifyUp(int index) {
        while(index > 0 && heap.get(getRootNodeIndex(index)).weight > heap.get(index).weight) {
            swap(heap.get(getRootNodeIndex(index)), heap.get(index));
            index = getRootNodeIndex(index);
        }
    }

    void heapifyDown(int index) {
        int leftIndex = getLeftNodeIndex(index);
        int rightIndex = getRightNodeIndex(index);
        int min = index;
        if(leftIndex < heap.size() && heap.get(leftIndex).weight < heap.get(min).weight)
            min = leftIndex;
        if(rightIndex < heap.size() && heap.get(rightIndex).weight < heap.get(min).weight)
            min = rightIndex;
        if(index != min) {
            swap(heap.get(index), heap.get(min));
            heapifyDown(min);
        }
    }

    void heapifyDown() {
        int index = heap.size() - 1;
        position.remove(heap.get(0).vertex);
        heap.get(0).vertex = heap.get(index).vertex;
        heap.get(0).weight = heap.get(index).weight;
        position.put(heap.get(0).vertex, 0);
        heap.remove(heap.size()-1);
        heapifyDown(0);
    }

    void removeVertex(int vertex) {
        int vertexIndex = position.get(vertex);
        Node currentVertex = heap.get(vertexIndex);
        currentVertex.weight = Integer.MIN_VALUE;
        heapifyUp(vertexIndex);
        heapifyDown();
    }

    List<Integer> extractMin() {
        Node min = new Node(heap.get(0).vertex, heap.get(0).weight);
        List<Integer> result = new ArrayList<>();
        result.add(min.vertex);
        result.add(min.weight);
        heapifyDown();
        return result; 
    }

    void decreaseKey(int vertex, int newWeight) {
        int vertexIndex = position.get(vertex);
        Node currentVertex = heap.get(vertexIndex);
        currentVertex.weight = newWeight;
        heapifyUp(vertexIndex);
    }


    void print() {
        for(Node n: heap) {
            System.out.println(n.vertex + " " + n.weight + " " + position.get((n.vertex)));
        }
    }



}
