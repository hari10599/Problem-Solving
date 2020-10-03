public class Main {
    public static void main(String[] args) throws Exception {
        int[] array = {5, 4, 3, 2, 1};
        QuickSort qs = new Pivot_Last_Element(array);
        qs.quicksort(0, array.length - 1);
        qs.print();
    }
}
