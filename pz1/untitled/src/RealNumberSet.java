import java.util.HashSet;
import java.util.Set;

public class RealNumberSet {
    private int power;
    private Set<Double> set;

    public RealNumberSet(int power) {
        this.power = power;
        this.set = new HashSet<> ();
    }

    public RealNumberSet(int power, Set<Double> set) {
        this.power = power;
        this.set = set;
    }

    public void addNumber(double number) {
        set.add (round (number, power * 2));
    }

    public RealNumberSet combine(RealNumberSet other) {
        Set<Double> combinedSet = new HashSet<> (this.set);
        combinedSet.addAll (other.set);

        return new RealNumberSet (this.power, combinedSet);
    }

    public boolean containsNumber(double number) {
        return set.contains (round (number, power * 2));
    }

    public void printSet() {
        for (double number : set) {
            System.out.println (round (number, power * 2));
        }
    }

    private double round(double number, int places) {
        double scale = Math.pow (10, places);
        return Math.round (number * scale) / scale;
    }
}