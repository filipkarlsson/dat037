/**
 * Created by filip on 2017-12-04.
 */
public class ManTest {
    public static void main(String[] args) {

        APrioMap<String, Integer> pm = new APrioMap<>();
        pm.put("K1", 3);
        System.out.println(pm.toString());
        pm.put("K0", 1);
        System.out.println(pm.toString());
        pm.poll();  // result: <K0,1>
        System.out.println(pm.toString());
        pm.get("K1");
        System.out.println(pm.toString());


    }
}
