import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Character {
    private String navn;
    private int health;
    private int armor;
    private int equippedWeapon;
    private int gold;

    ArrayList<Integer> egedeVåben = new ArrayList<>();

    public void gemHealth() {
        try {
            PrintWriter outputStream = new PrintWriter(new File("saves/health"));
                outputStream.println(
                  health + ";" + armor + ";" + equippedWeapon + ";" + gold + ";" + navn + ";"
                );
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void laesHealth() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("saves/health")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextInt()) {
            health = scanner.nextInt();
            armor = scanner.nextInt();
            equippedWeapon = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public void gemWeaponList() {
        try {
            PrintWriter outputStream = new PrintWriter(new File("saves/weapons"));
            for (int i = 0; i < egedeVåben.size(); i++) {
                outputStream.println(
                        egedeVåben.get(i).intValue()+";");
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void laesWeaponList() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("saves/weapons")).useDelimiter(";").useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextInt()) {
            int våben = scanner.nextInt();

            egedeVåben.add(våben);
            scanner.nextLine();
        }
    }

    public static Weapon weapons(int svar) {
        Weapon weapon = new Weapon("",0,0);
        switch (svar) {
            case 0:
                weapon = new Weapon("Bare Hænder",1,2);
                break;
            case 1:
                weapon = new Weapon("Flad Kniv",1,3);
                break;
            case 2:
                weapon = new Weapon("Kniv",2,3);
                break;
            case 3:
                weapon = new Weapon("Skarp Kniv",2,5);
                break;
            case 4:
                weapon = new Weapon("Flad Økse",3,7);
                break;
            case 5:
                weapon = new Weapon("Økse",4,7);
                break;
            case 6:
                weapon = new Weapon("Skarp Økse",4,9);
                break;
            case 7:
                weapon = new Weapon("Fladt Sværd",3,12);
                break;
            case 8:
                weapon = new Weapon("Sværd",6,13);
                break;
            case 9:
                weapon = new Weapon("Skarpt Sværd",8,15);
                break;
            default: break;

        }
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(int equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
