import java.util.*;
class Subsets {
    public static void combinations(int[] array, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        if(index == array.length)
            return;
        for(int i = index; i < array.length; i++) {
            current.add(array[i]);
            combinations(array, i + 1, current, result);
            current.remove(current.size()-1);
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        combinations(array, 0, new ArrayList<>(), result);
        System.out.println(result);
        
        
    }
}