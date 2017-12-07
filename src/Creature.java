public class Creature {

    private String navn;
    private int min;
    private int max;
    private int hp;

    private Creature(String navn, int min, int max, int hp) {
        this.navn = navn;
        this.min = min;
        this.max = max;
        this.hp = hp;
    }

    public static Creature creature(int svar) {
        Creature creature = new Creature("", 0,0,0);
        switch (svar) {
            case 0:
                creature = new Creature("Slange", 1,2,10);
                break;
            case 1:
                creature = new Creature("Vildsvin",5,8,40);
                break;

        }
        return creature;
    }



    //GETTERS AND SETTERS

    public String getNavn() {
        return navn;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getHp() {
        return hp;
    }
}
