/**
 * Created by filip on 2017-12-04.
 */
public class ManTest {
    public static void main(String[] args) {

        Graph g = new Graph();
        g.addVertice("V0");
        Graph.Path p = g.shortestPath("V0", "V0");
        System.out.print(p);

    }
}
