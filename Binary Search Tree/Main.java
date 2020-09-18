class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        int []add = {5, 3, 6, 2, 4, 1};
        for(int i: add)
            bst.insert(i);
        bst.inorder();
        bst.kthSmallest(3);
    }
}