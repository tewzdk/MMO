import java.util.Random;

public class Combat {
    boolean minbool = true;
    int min;
    int max;
    int hit;

    Random random = new Random();


    public int Angreb(int min, int max) {
        hit = random.nextInt(max)+1;
        while (minbool) {
            if (hit < min) {
                hit = random.nextInt(max)+1;
            } else if (hit == min || hit > min){
                minbool = false;
            }
        }
        minbool = true;
        return hit;
    }

}
