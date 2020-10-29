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

    public int hashCode(int key) {
        return key % capacity;
    }
    
    
    public void reHashing() {
        Node[] newMap = new Node[capacity * 2];
        for(Node n : map) {
            Node head = n;
            while(head != null) {
                putHelper(newMap, head.key, head.value);
                head = head.next;
            }
        }
        map = new Node[capacity * 2];
        for(int i = 0; i < capacity; i++) {
            map[i] = newMap[i];
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(currentCapacity == (int)loadFactor * capacity) {
            reHashing();
            capacity *= 2;
        }
        putHelper(map, key, value);
    }
    
    public void putHelper(Node[] map, int key, int value) {
        Node curr = new Node(key, value);
        int index = hashCode(key);
        if(map[index] == null) {
            map[index] = curr;
            currentCapacity++;
        }
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
            if(temp == null){
                prev.next = curr;
                currentCapacity++;
            }
            else
                temp.value = value;
        }


    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashCode(key);
        Node head = map[index];
        while(head != null) {
            if(head.key == key)
                return head.value;
            head = head.next;
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
                    currentCapacity--;
                    if(prev == null)
                        map[index] = head.next;    
                    else
                        prev.next = head.next;
                    break;
                    
                }
                prev = head;
                head = head.next;
            }
        }
    }
    

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */