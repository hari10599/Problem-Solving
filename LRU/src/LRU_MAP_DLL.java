import java.util.*;

class LRU_MAP_DLL {
    class Node {
        int key;
        int value;
        Node left;
        Node right;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
            left = right = null;
        }
    }
    Map<Integer, Node> map;
    int capacity;
    Node front;
    Node rear;
    public LRU_MAP_DLL(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        front = rear = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node curr = map.get(key);
        remove(curr);
        addFirst(curr);
        return curr.value;
    }
    
    
    public void addFirst(Node curr) {
        if(front == null) {
            front = rear = curr;
            return;
        }
        front.left = curr;
        curr.right = front;
        front = curr;
    }
    
    public void remove(Node curr) {
        if(front == curr && rear == curr) {
            front = rear = null;
            return;
        }
        if(front == curr) {
            front = front.right;
            front.left = null;
            return;
        }
        if(rear == curr) {
            rear = rear.left;
            rear.right = null;
            return;
        }
        Node prev = curr.left;
        Node next = curr.right;
        prev.right = next;
        next.left = prev;
    }
    
    public Node removeLast() {
        if(front == rear) {
            Node temp = front;
            front = rear = null;
            return temp;
        }
        Node temp = rear;
        rear = rear.left;
        rear.right = null;
        return temp;
    }
    
    public void put(int key, int value) {
        Node curr = map.containsKey(key)?map.get(key):null;
        if(curr == null) {
            curr = new Node(key, value);
            addFirst(curr);
            map.put(key,curr);
        }
        else {
            curr.value = value;
            remove(curr);
            addFirst(curr);
        }
        if(map.size() > capacity) {
            curr = removeLast();
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