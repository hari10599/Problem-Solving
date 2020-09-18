public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] toAdd = {"ab", "aba", "bab", "b", "abc"};
        for(String s: toAdd) {
            trie.add(s);
        }
        //System.out.println(trie.search("bab"));
        trie.remove("b");
        System.out.println(trie.findPrefix(""));
    }
}