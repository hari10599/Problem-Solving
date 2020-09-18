import java.util.*;
public class Trie {
    private Node root;
    class Node {
        Node[] children;
        Boolean isEnd;
        String word;

        Node(){
            this.children = new Node[26];
            for(int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
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
            int index = c - 'a';
            if(curr.children[index] == null)
                curr.children[index] = new Node();    
            curr = curr.children[index];
        }
        curr.isEnd = true;
        curr.word = word;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null)
                return false;
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    public List<String> findPrefix(String word) {
        Node curr = root;
        List<String> result = new ArrayList<>();
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null)
                return result;
            curr = curr.children[index];
        }
        findPrefixRecurse(curr, result);
        return result;
    }

    private void findPrefixRecurse(Node curr, List<String> result) {
        if(curr.isEnd) {
            result.add(curr.word);
        }
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null)
                findPrefixRecurse(curr.children[i], result);
        }
    }

    private boolean isEmpty(Node curr) {
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null)
                return false;
        }
        return true;
    }

    public void remove(String s) {
        Node n = remove(s, root, 0);
    }

    private Node remove(String s, Node curr, int i) {
        if(curr == null || s.length() == 0) {
            return null;
        }
        if(i == s.length()) {
            if(curr.isEnd)
                curr.isEnd = false;
            return isEmpty(curr)? null : curr;
        }
        int index = s.charAt(i) - 'a';
        curr.children[index] = remove(s, curr.children[index], i + 1);
        if(isEmpty(curr) && !curr.isEnd) {
            return null;
        }
        return curr;
    }
}
