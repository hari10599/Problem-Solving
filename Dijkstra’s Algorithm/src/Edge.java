public class Edge {
    int vertex;
    int distance;

    Edge(int v, int w) {
        this.vertex = v; //destinationVertex
        this.distance = w;
    }

    public String toString() {
        return this.vertex + " " + this.distance;
    }
}
