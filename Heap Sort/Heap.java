abstract class Heap {
    int size;
    int index;
    int[] heap;

    public int leftIndex(int curr) {
        return 1 + curr*2;
    }

    public int rightIndex(int curr) {
        return 2 + curr*2;
    }

    public int rootIndex(int curr) {
        if(curr == 0)
            return 0;
        return (curr - 1)/2;
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    abstract public void insert(int value);
    abstract public void remove();
    abstract public void print();
}