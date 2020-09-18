import java.util.*;
public class BST {
    private Node root;
    class Node {
        int value;
        Node left;
        Node right;
        int children;
        Node(int v) {
            this.value = v;
            this.children = 0;
            this.left = this.right = null;
        }
    }

    BST() {
        this.root = null;
    }

    public void insert(int value) {
        Node curr = root;
        if(curr == null) {
            root = new Node(value);
            return;
        }
        //addRecurse(curr,value);
        addIterative(curr, value);
        return;
    }

    private Node addRecurse(Node curr, int value) {
        if(curr == null) {
            Node temp = new Node(value);
            return temp;
        }
        curr.children++;
        if(curr.value > value) {
            curr.left = addRecurse(curr.left, value);
            return curr;
        }
        curr.right = addRecurse(curr.right, value);
        return curr;
    }

    private void addIterative(Node curr, int value) {
        Node prev = curr;
        while(curr != null) {
            curr.children++;
            prev = curr;
            if(curr.value > value)
                curr = curr.left;
            else
                curr = curr.right;
        }
        if(prev.value > value)
            prev.left = new Node(value);
        else
            prev.right = new Node(value);
    }

    public void kthSmallest(int value) {
        Node curr = root;
        System.out.println(value + " Smallest: "+kthSmallest(curr, value-1));
    }

    private int kthSmallest(Node curr, int value) {
        if(nodeCount(curr.left) == value) {
            return curr.value;
        }
        if(nodeCount(curr.left) > value) {
            return kthSmallest(curr.left, value);
        }
        return kthSmallest(curr.right, value - nodeCount(curr.left)-1);
    }

    private int nodeCount(Node curr) {
        if(curr == null)
            return 0;
        return curr.children + 1;
    }


    public void inorder() {
        List<String> result = new ArrayList<>();
        inorder(root,result);
        System.out.println("Inorder : " + result);
        return;
    }

    private void inorder(Node root, List<String> result) {
        if(root == null)
            return;
        inorder(root.left, result);
        result.add(root.value +"("+root.children+")");
        inorder(root.right, result);
    }

}