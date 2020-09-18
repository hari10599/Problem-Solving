class DisjointSet {
    int vertexCount;
    int[] vertex;
    int[] parent;
    int[] rank;
    DisjointSet(int v) {
        this.vertexCount = v;
        this.vertex = new int[v];
        this.parent = new int[v];
        this.rank = new int[v];
    }

    void makeSet() {
        for(int i = 0; i < vertexCount; i++) {
            this.vertex[i] = i;
            this.parent[i] = i;
        }
    }

    int findSet(int v) {
        if(v == this.parent[v])
            return v;
        parent[v] = findSet(parent[v]);
        return parent[v];
    }

    void union(int v1, int v2) {
        int parent1 = findSet(v1);
        int parent2 = findSet(v2);
        int rank1 = rank[parent1];
        int rank2 = rank[parent2];
        if(parent1 == parent2)
            return;
        if(rank1 > rank2)
            parent[parent2] = parent1;
        else if(rank2 > rank1)
            parent[parent1] = parent2;
        else {
            parent[parent2] = parent1;
            rank[parent1]++;
        }
    }

    void print() {
        for(int i = 0; i < vertexCount; i++) {
            System.out.println(vertex[i]+" "+parent[i]+" "+rank[i]);
        }
    }

}