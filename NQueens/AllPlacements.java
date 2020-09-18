import java.util.*;
class AllPlacements {
    static List<List<String>> placements = new ArrayList<>();

    public static List<Integer> decodeString(String s) {
        List<Integer> index = new ArrayList<>();
        String[] current = s.split(" ");
        index.add(Integer.parseInt(current[0]));
        index.add(Integer.parseInt(current[1]));
        return index;
    }

    public static boolean isValid(String s, List<String > positions) {
        List<Integer> current = decodeString(s);
        for(int i = 0; i < positions.size(); i++) {
            List<Integer> pos = decodeString(positions.get(i));
            if(current.get(1) == pos.get(1) || Math.abs(current.get(0)-pos.get(0)) == Math.abs(current.get(1)-pos.get(1)))
                return false;
        }
        return true;
    }

    public static void backTracking(int index, int n, List<String > positions) {
        if(positions.size() == n) {
            placements.add(new ArrayList<>(positions));
            return;
        }
        for(int i = 0; i < n; i++) {
            String current = index + " " + i;
            if(isValid(current, positions)) {
                positions.add(current);
                backTracking(index + 1, n, positions);                               
                positions.remove(positions.size() - 1);
            }

        }

    }


    public static void main(String[] args) {
        int n = 4;
        List<String> result = new ArrayList<>();
        backTracking(0, n, result);
        System.out.println(placements);

    }
}