public class Pivot_Middle_Element extends QuickSort{
    Pivot_Middle_Element(int[] array) {
        super(array);
    }

    void quicksort(int low, int high) {
        if(low >= high)
            return;
        int middle = low + (high - low)/2;
        int pivot = partition(low, high, array[middle]);
        
        if(low < pivot - 1)
            quicksort(low, pivot - 1);
        if(pivot < high)
            quicksort(pivot, high);
            
    }

//{10, 80, 30, 90, 40, 50, 70}

    int partition(int low, int high, int pivotValue) {

        while(low < high) {
            while(low < high && array[low] < pivotValue)
                low++;
            while(low < high && array[high] > pivotValue)
                high--;
            if(low <= high) {
                swap(low, high);
                low++;
                high--;
            }
        }

        return low;
    }

}
