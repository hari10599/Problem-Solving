class Node {
    int key;
    int value;
    Node next;
    
    Node(int k, int v) {
        this.key = k;
        this.value = v;
        this.next = null;
    }
    
}
class HashMap {
    Node[] map;
    int currentCapacity;
    int capacity;
    float loadFactor;
    
    /** Initialize your data structure here. */
    public HashMap() {
        loadFactor = 0.75f;
        currentCapacity = 0;
        capacity = 16;
        map = new Node[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node curr = new Node(key, value);
        int index = hashCode(key);
        if(map[index] == null) 
            map[index] = curr;
        else {
            Node temp = null;
            Node prev = null;
            Node head = map[index];
            while(head != null) {
                if(key == head.key) {
                    temp = head;
                    break;
                }
                prev = head;
                head = head.next;
            }
            if(temp == null) 
                prev.next = curr;
            else
                temp.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashCode(key);
        if(map[index] == null)
            return -1;
        else {
            Node head = map[index];
            while(head != null) {
                if(head.key == key)
                    return head.value;
                head = head.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashCode(key);
        if(map[index] != null) {
            Node head = map[index];
            Node prev = null;
            while(head != null) {
                if(head.key == key) {
                    if(prev == null)
                        map[index] = prev;    
                    else
                        prev.next = head.next;
                    break;
                    
                }
                prev = head;
                head = head.next;
            }
        }
    }
    
    public int hashCode(int key) {
        return key % capacity;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */