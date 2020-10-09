import java.util.*;
public class App {

    public static List<Pair> allPairs(int []array, int target) {
        List<Pair> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: array) {
            int diff = target - i;
            if(map.containsKey(diff)) {
                int count = map.get(diff);
                for(int c = 0; c < count; c++)
                    result.add(new Pair(i, diff));
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return result;
    }

    public static List<Pair> uniquePairs(int []array, int target) {
        List<Pair> result = new ArrayList<>();
        Set<Integer> values = new HashSet<>();
        Set<Integer> diffSeen = new HashSet<>(); 
        
        for(int i: array) {
            int diff = target - i;
            if(values.contains(diff) && !diffSeen.contains(diff)) {
                result.add(new Pair(i, diff));
                diffSeen.add(diff);
            }
            values.add(i);
        }

        return result;
    }

    public static void print(List<Pair> result) {
        for(Pair p: result)
            System.out.println(p.x + " " + p.y);
    }

    public static void main(String[] args) throws Exception {
        int []array ={1, 1, 5, 5};
        int target = 6;
        List<Pair> allPairResult = allPairs(array, target);
        System.out.println("All pairs : ");
        print(allPairResult);
        List<Pair> uniquePairsResult = uniquePairs(array, target);
        System.out.println("Unique pairs : ");
        print(uniquePairsResult);
    }
}
