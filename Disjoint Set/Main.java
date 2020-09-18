class Main {
    public static void main(String[] args) {
        DisjointSet dset = new DisjointSet(8);
        dset.makeSet();
        int[][] edges = {{1,2},{2,3},{4,5},{6,7},{5,6},{3,7}};
        for(int[] i: edges)
            dset.union(i[0],i[1]);
        for(int i = 0; i < 8; i++) {
            dset.findSet(i);
        }
        dset.print();

    }
}