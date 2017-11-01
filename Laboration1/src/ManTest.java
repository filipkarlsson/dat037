class ManTest {
    public static void main(String[] args) {
        IntSet set = new BinSearchIntSet();
        set.add(-1);
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(-2);
        set.remove(3);
        set.remove(1);
        System.out.println("-3: " + set.contains(-3));
        System.out.println("-2: " + set.contains(-2));
        System.out.println("-1: " + set.contains(-1));
        System.out.println("0: " + set.contains(0));
        System.out.println("1: " + set.contains(1));
        System.out.println("2: " + set.contains(2));
        System.out.println("3: " + set.contains(3));
        System.out.println("4: " + set.contains(4));
        System.out.println("5: " + set.contains(5));
    }
}