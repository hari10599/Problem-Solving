public abstract class QuickSort {
    int[] array;
    int length;

    QuickSort(int []array) {
        this.length = array.length;
        this.array = array.clone();
    }

    void print() {
        for(int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    abstract void quicksort(int low, int high);

}
