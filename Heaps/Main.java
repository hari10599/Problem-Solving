class Main {
    public static void main(String[] args) {
        Heap minHeap = new MinHeap(8);
        int[] add = {20,17,3,2,15,15};
        for(int i :add) {
            minHeap.insert(i);
        }
        minHeap.print();
        minHeap.remove();
        minHeap.print();
        minHeap.remove();
        minHeap.print();
        minHeap.remove();
        minHeap.print();
        System.out.println("************");
        Heap maxHeap = new MaxHeap(8);
        int[] addd = {4,7,1,8,10,3, 20};
        for(int i: addd)
            maxHeap.insert(i);
        maxHeap.print();
        maxHeap.remove();
        maxHeap.print();
        maxHeap.remove();
        maxHeap.print();

    }
}