public class Main {
    public static void main(String[] args) throws Exception {
        int[] array = {10, 80, 30, 90, 40, 50, 70};
        QuickSort qs = new Pivot_Last_Element(array);
        qs.quicksort(0, array.length - 1);
        System.out.print("Pivot as Last ELement :   ");
        qs.print();
        qs = new Pivot_Middle_Element(array);
        qs.quicksort(0, array.length - 1);
        System.out.print("Pivot as Midlle ELement : ");
        qs.print();
    }
}
