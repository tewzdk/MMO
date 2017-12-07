public class Weapon {

    private String name;
    private int min;
    private int max;

    public Weapon(String name, int min, int max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


    @Override
    public String toString() {
        return getName() + " (" + ((getMax()+getMin())/2)+ ") " + getMin() + " - " + getMax();
    }
}