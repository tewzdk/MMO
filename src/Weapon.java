public class Weapon {

    private String name;
    private int min;
    private int max;
//HEJ
    public Weapon(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        double mingns = getMin();
        double maxgns = getMax();
        return getName() + " (" + ((maxgns+mingns)/2)+ ") " + getMin() + " - " + getMax();
    }
}