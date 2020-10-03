public class Pivot_Last_Element extends QuickSort{
    Pivot_Last_Element(int[] array) {
        super(array);
    }

    int partition(int low, int high, int pivot) {
        int index = 0;
        for(int i = 0; i < length; i++) {
            if(array[i] < pivot) {
                swap(i, index);
                index++;
            }
        }
        swap(index, high);
        return index;
    }
//{10, 80, 30, 90, 40, 50, 70}

    void quicksort(int low, int high) {
        if(low >= high)
            return;
        int pivot = partition(low, high, array[high]);
        quicksort(low, pivot - 1);
        quicksort(pivot + 1, high);
    }


}
