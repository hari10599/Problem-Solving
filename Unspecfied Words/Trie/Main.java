public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] toAdd = {"bat","mat","cat", "batter", "batt"};
        for(String s: toAdd) {
            trie.add(s);
        }
        System.out.println(trie.findPrefix(""));
    }
}