class ManTest {
    public static void main(String[] args) {
       /* IntSet set = new BinSearchIntSet();

        set.add(0);
        set.add(-2);
        set.add(-1);
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(0);
        set.add(4);
        set.add(5);
        //set.remove(5);
        set.remove(5);
        //set.add(12);
        System.out.println("-3: " + set.contains(-3));
        System.out.println("-2: " + set.contains(-2));
        System.out.println("-1: " + set.contains(-1));
        System.out.println("0: " + set.contains(0));
        System.out.println("1: " + set.contains(1));
        System.out.println("2: " + set.contains(2));
        System.out.println("3: " + set.contains(3));
        System.out.println("4: " + set.contains(4));
        System.out.println("5: " + set.contains(5));

        System.out.println(set.toString());



        set.remove(7);
        set.remove(6);
        set.add(1);
        set.contains(4);  // result: false
        set.add(6);
        System.out.println(set.toString());
        set.remove(1);
        System.out.println(set.toString());
        set.add(0);
        System.out.println(set.toString());
        set.contains(6);  // result: false

        System.out.println(set.toString());
*/



        IntSet set = new BinSearchGenSetAsIntSet();
        set.add(1);
        set.add(0);
        System.out.println(set.contains(0));

        GenSet<String> kurser = new BinSearchGenSet<>();
        System.out.println(kurser.toString());

        kurser.add("DAT037");
        System.out.println(kurser.toString());

        kurser.add("DAT037");
        System.out.println(kurser.toString());

        kurser.add("SSY051");
        System.out.println(kurser.toString());

        kurser.add("SSY066");
        System.out.println(kurser.toString());

        kurser.add("TME122");
        System.out.println(kurser.toString());

        kurser.remove("SSY051");
        System.out.println(kurser.toString());

        System.out.println(kurser.contains("MVE041"));
        System.out.println(kurser.contains("SSY051"));
        System.out.println(kurser.contains("SSY066"));
        System.out.println(kurser.contains("TME122"));
        System.out.println(kurser.contains("Filip"));

        kurser.remove("hej");
        System.out.println(kurser.toString());


    }
}