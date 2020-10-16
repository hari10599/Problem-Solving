import java.util.*;

class LRU_MAP_DQ {
    class Node{
        int key;
        int value;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    Map<Integer, Node> map;
    Deque<Node> dq;
    int capacity;
    public LRU_MAP_DQ(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dq = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        dq.remove(map.get(key));
        dq.addFirst(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        Node curr = map.containsKey(key)?map.get(key):null;
        if(curr == null) {
            curr = new Node(key, value);
            dq.addFirst(curr);
            map.put(key, curr);
        }
        else {
            curr.value = value;
            dq.remove(curr);
            dq.addFirst(curr);
        }
        if(map.size() > capacity) {
            curr = dq.removeLast();
            map.remove(curr.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */