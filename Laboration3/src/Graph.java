import java.util.*;

public class Graph {
    private HashMap<String, LinkedList<Pair<String, Integer>>> nodes;

    public Graph() {
        nodes = new HashMap<>();
    }

    public void addVertice(String label) {
        nodes.put(label, new LinkedList<>());
    }

    public void addEdge(String node1, String node2, int dist) {
        nodes.get(node1).add(new Pair<>(node2, dist));
        nodes.get(node2).add(new Pair<>(node1, dist));
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
        HashMap<String, Integer> d = new HashMap<>();
        for (String s : nodes.keySet()){
            d.put(s,Integer.MAX_VALUE);
        }
        HashSet<Pair<String, Integer>> shortestPathFound = new HashSet<>();
        HashMap<String, String> predecessor = new HashMap<>();

        PrioMap<String, Integer> q = new APrioMap<>();
        q.put(start, 0);
        d.put(start, 0);

        while (q.peek() != null) {
            Pair<String, Integer> v = q.poll();
            if (!shortestPathFound.contains(v)){
                shortestPathFound.add(v);

                for (Pair<String, Integer> succesor : nodes.get(v.a)){ // for all succesors
                     if (!shortestPathFound.contains(succesor) &&  d.get(succesor.a) > d.get(v.a) + succesor.b){
                         d.replace(succesor.a, d.get(v.a) + succesor.b);
                         predecessor.put(succesor.a, v.a);
                         q.put(succesor.a, succesor.b);
                    }
                }

            }
        }

        if (d.get(dest) == Integer.MAX_VALUE) return null;
        LinkedList<String> pathList = new LinkedList();
        pathList.add(dest);
        while (pathList.get(0) != start){
            pathList.addFirst(predecessor.get(pathList.getFirst()));
        }

        return new Path(d.get(dest), pathList);

    }
}