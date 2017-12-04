import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private ArrayList<Pair<String, PrioMap<String,Integer>>> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addVertice(String label) {
        nodes.add(new Pair<>(label, new APrioMap<>()));
    }

    public void addEdge(String node1, String node2, int dist) {
        for (Pair<String, PrioMap<String,Integer>> p : nodes) {
            if (p.a.equals(node1)){
                p.b.put(node2,dist);
            }
            if (p.a.equals(node2)){
                p.b.put(node1,dist);
            }
        }

    }

    public static class Path {
        public int totalDist;
        public List<String> vertices;
        public Path(int totalDist, List<String> vertices) {
            this.totalDist = totalDist;
            this.vertices = vertices;
        }

        @Override
        public String toString() {
            return "totalDist: " + totalDist + ", vertices: " + vertices.toString();
        }
    }

    public Path shortestPath(String start, String dest) {
        HashMap<String,Pair<>>

    }
}