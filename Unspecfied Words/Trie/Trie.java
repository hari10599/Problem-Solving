package Trie;
import java.util.*;
public class Trie {
    protected Node root;
    public class Node {
        public Map<Character, Node> children;
        public Boolean isEnd;
        public String word;

        public Node(){
            this.children = new HashMap<>();
            this.isEnd = false;
            this.word = null;
        }
    }

    public Trie(){
        this.root = new Node();
    }

    public void add(String word) {
        Node curr = root;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c))
                curr.children.put(c, new Node());    
            curr = curr.children.get(c); 
        }
        curr.isEnd = true;
        curr.word = word;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }

    public List<String> findPrefix(String word) {
        Node curr = root;
        List<String> result = new ArrayList<>();
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c))
                return result;
            curr = curr.children.get(c);
        }
        findPrefixRecurse(curr, result);
        return result;
    }

    private void findPrefixRecurse(Node curr, List<String> result) {
        if(curr.isEnd) {
            result.add(curr.word);
        }
        for(char c: curr.children.keySet()) {
            findPrefixRecurse(curr.children.get(c), result);
        }
    }

}
