public class Main {

    public static void main(String[] args) throws Exception {
        MinHeap_Map minheap = new MinHeap_Map();
        minheap.addVertex(1, 4);
        minheap.addVertex(2, 2);
        minheap.addVertex(3, 9);
        minheap.addVertex(4, 1);
        minheap.addVertex(5, 2);
        minheap.addVertex(6, 3);
        minheap.print();
        minheap.removeVertex(2);
        minheap.print();
        System.out.println(minheap.extractMin());
        minheap.print();
        minheap.decreaseKey(3, 0);
        minheap.print();
    }
}
