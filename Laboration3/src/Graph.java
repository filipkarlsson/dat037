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
        HashSet<Pair<String, Integer>> k = new HashSet<>();
        HashMap<String, String> p = new HashMap<>();

        PrioMap<String, Integer> q = new APrioMap<>();

        for (String s : nodes.keySet()){
            d.put(s,Integer.MAX_VALUE);
        }

        q.put(start, 0);
        d.put(start, 0);

        while (q.peek() != null) {
            Pair<String, Integer> v = q.poll();
            if (!k.contains(v)){
                k.add(v);

                for (Pair<String, Integer> successor : nodes.get(v.a)){ // for all succesors
                    int oldShortestPathLength = d.get(successor.a);
                    int newPathLength = d.get(v.a) + successor.b;

                     if (!k.contains(successor) &&  oldShortestPathLength > newPathLength){
                         d.replace(successor.a, newPathLength);
                         p.put(successor.a, v.a);
                         q.put(successor.a, d.get(successor.a));
                    }
                }

            }
        }

        if (d.get(dest) == Integer.MAX_VALUE) return null;
        LinkedList<String> pathList = new LinkedList<>();
        pathList.add(dest);
        while (!pathList.get(0).equals(start)){
            pathList.addFirst(p.get(pathList.getFirst()));
        }

        return new Path(d.get(dest), pathList);

    }
}