import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Scanner in = new Scanner(System.in).useDelimiter("\\n");

    public static void main(String[] args) {


        GameRunner runner = new GameRunner();

        runner.start();

    }

    public int in(){
        int svar = -1;

        try {
            svar = in.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Indtast venligst et nummer:");
            in.nextLine();
        }

        return svar;
    }

    public String inputString(){
        String string = in.next();
        return string;
    }


}
