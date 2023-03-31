public class Main {
    public static void main(String[] args) {
        RealNumberSet set1 = new RealNumberSet(2);
        RealNumberSet set2 = new RealNumberSet(3);

        set1.addNumber(1.2345);
        set1.addNumber(2.3456);
        set2.addNumber(1.2345);
        set2.addNumber(3.4567);

        System.out.println("\n-------Set 1-------\n");
        set1.printSet ();
        System.out.println("\n-------Set 2-------\n");
        set2.printSet ();
        RealNumberSet combinedSet = set1.combine(set2);
        System.out.println("\n-------Combined set-------\n");
        combinedSet.printSet();

        System.out.println("Set contains 2.3456: " + combinedSet.containsNumber(2.3456));
        System.out.println("Set contains 4.5678: " + combinedSet.containsNumber(4.5678));
    }
}