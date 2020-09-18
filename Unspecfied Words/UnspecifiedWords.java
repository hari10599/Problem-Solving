import Trie.*;
import java.util.*;
public class UnspecifiedWords extends Trie{

    public List<String> wordMatch(String word) {
        List<String> result = new ArrayList<>();
        Node curr = root;
        wordMatchRecurse(word, 0, curr, result);
        return result;
    }

    public void wordMatchRecurse(String word, int index, Node curr, List<String> result) {
        if(curr.isEnd) {
            result.add(curr.word);
            return;
        }

        for(int i = index; i < word.length(); i++){
            if(word.charAt(i) == '?') {
                for(char c: curr.children.keySet()) {
                    wordMatchRecurse(word, i + 1, curr.children.get(c), result);
                }
            }
            else {
                if(curr.children.containsKey(word.charAt(i))) {
                    wordMatchRecurse(word, i + 1, curr.children.get(word.charAt(i)), result);    
                }
                else
                    return;
            }
        }
    }

    public static void main(String[] args) {
        UnspecifiedWords trie = new UnspecifiedWords();
        String[] toAdd = {"cat","bat","map","pen","man"};
        for(String s: toAdd) {
            trie.add(s);
        }
        String[] query = {"?at","ma?","?a?","??n"};
        for(String s: query) {
            System.out.println(trie.wordMatch(s));
        }
    }
}