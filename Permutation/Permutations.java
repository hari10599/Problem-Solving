import java.util.*;
class Permutations {
    public static void permutations(char[] letter, int[] count, int index, int totalLength, char[] current, List<String> result) {
        if(index == totalLength) {
            result.add(new String(current));
        }
        for(int i = 0; i < totalLength; i++) {
            if(count[i] != 0) {
                current[index] = letter[i];
                count[i]--;
                permutations(letter, count, index + 1, totalLength, current, result);
                count[i]++;
            }
        }
    }
   
    
    
    
    public static void main(String[] args) {
        String s = "ABCCA";
        Map<Character, Integer> map = new TreeMap<>();
        List<String> result = new ArrayList<>();
        for(Character c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        char[] letter = new char[s.length()];
        int[] count = new int[s.length()];
        int index = 0;
        for(Character c: map.keySet()) {
            letter[index] = c;
            count[index++] = map.get(c);
        }
        permutations(letter, count, 0, s.length(), new char[s.length()], result);
        System.out.println(result);
        System.out.println(result.size());     
    }
}