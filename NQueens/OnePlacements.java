import java.util.*;
class OnePlacements {

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

    public static boolean backTracking(int index, int n, List<String > positions) {
        if(positions.size() == n) {
            return true;
        }
        for(int i = 0; i < n; i++) {
            String current = index + " "+ i;
            if(isValid(current, positions)) {
                positions.add(current);
                if(backTracking(index+1, n, positions)) {
                    return true;
                }
                positions.remove(positions.size()-1);
            }
        }
        return false;

    }


    public static void main(String[] args) {
        int n = 4;
        List<String> result = new ArrayList<>();
        System.out.println(backTracking(0, n, result));

    }
}