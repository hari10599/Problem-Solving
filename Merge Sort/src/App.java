public class App {

    static void merge(int []array, int low, int mid, int high) {
        int s1 = mid - low + 1;
        int s2 = high - mid;
        int []array1 = new int[s1];
        int []array2 = new int[s2];

        for(int i = 0; i < s1; i++)
            array1[i] = array[low + i];
        for(int i = 0; i < s2; i++)
            array2[i] = array[mid + 1 +  i];

        int i = 0, j = 0, k = low;
        while(i < s1 && j < s2) {
            if(array1[i] < array2[j])
                array[k] = array1[i++];
            else
                array[k] = array2[j++];
            k++;
        }

        while(i < s1)
            array[k++] = array1[i++];
        while(j < s2)
            array[k++] = array2[j++];
    }


    static void mergeSort(int []array, int low, int high) {
        if(low < high) {
            int mid = low + (high - low)/2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            merge(array, low, mid, high);
        }
    }
    public static void main(String[] args) throws Exception {
        int []array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(array, 0, array.length - 1);
        for(int i: array)
            System.out.print(i + " ");
    }
}
