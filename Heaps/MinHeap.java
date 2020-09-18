class MinHeap extends Heap{

    MinHeap(int size) {
        this.size = size;
        this.index = 0;
        heap = new int[size];
    }

    public void insert(int value) {
        if(index == size) {
            System.out.println("FULL");
            return;
        }
        int curr = index;
        heap[index++] = value;
        while(curr > 0 && heap[rootIndex(curr)] > heap[curr]) {
            swap(rootIndex(curr),curr);
            curr = rootIndex(curr);
        }
    }

    public void remove() {
        if(index == 0) {
            System.out.println("Empty");
            return;
        }
        System.out.println("Min: " + heap[0]);
        heap[0] = heap[--index];
        heapify(0);
    } 

    private void heapify(int curr) {
        int left = leftIndex(curr);
        int right = rightIndex(curr);
        int min = curr;
        if(left < index && heap[left] < heap[min])
            min = left;
        if(right < index && heap[right] < heap[min])
            min = right;
        if(min != curr) {
            swap(min,curr);
            heapify(min);
        }
    }


    public void print() {
        for(int i = 0; i < index; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}