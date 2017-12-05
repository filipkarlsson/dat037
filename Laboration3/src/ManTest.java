/**
 * Created by filip on 2017-12-04.
 */
public class ManTest {
    public static void main(String[] args) {

        Graph g = new Graph();
        g.addVertice("V0");
        g.addVertice("V1");
        g.addVertice("V2");
        g.addVertice("V3");
        g.addVertice("V4");
        g.addVertice("V5");
        g.addVertice("V6");
        g.addEdge("V4", "V6", 0);
        g.addEdge("V4", "V0", 6);
        g.addEdge("V0", "V2", 4);
        g.addEdge("V4", "V2", 3);
        g.addEdge("V6", "V3", 3);
        g.addEdge("V3", "V5", 4);
        g.addEdge("V2", "V6", 5);
        Graph.Path res = g.shortestPath("V3", "V4");  // result: totalDist: 3, vertices: [V3, V6, V4]
        res = g.shortestPath("V0", "V3");  // result: totalDist: 12, vertices: [V0, V4, V6, V3]


    }
}
