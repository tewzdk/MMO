import java.util.Scanner;

public class GameRunner {

    public void start() {
        boolean programRunning = true;
        Main main = new Main();

        while (programRunning) {
            programRunning = mainMenu(main);
        }
    }

    public boolean mainMenu(Main main) {
        System.out.println("Velkommen til spillet");
        boolean aktiv;
        int svar = main.in();
        switch (svar) {
            case 0:
                System.out.println("[Spillet afsluttes]");
                return false;
            case 1:
                aktiv = true;

                    rod(main);

                break;
            case 2:
                aktiv = true;
                while (aktiv) {

                }
                break;
            case 3:
                aktiv = true;
                while (aktiv) {

                }
                break;
            default:
                System.out.println("'"+svar+"' er ikke et korrekt valg");
        }





        return true;
    }

    public void rod(Main main) {
        boolean aktiv = true;
        Combat combat = new Combat();
        Creature creature = Creature.creature(0);
        Character character = new Character();


        System.out.println("Vælg våben");
        int vaaben = main.in();
        Weapon weapon = character.equipWeapon(vaaben);
        int min = weapon.getMin();
        int max = weapon.getMax();

        System.out.println("En " + creature.getNavn() + " dukkede op bag et træ");
        int hp = creature.getHp();

        System.out.println("Vil du kæmpe mod den?\n1. Ja\n2. Nej");
        int kamp = main.in();
        if (kamp == 1) {

        } else {
            aktiv = false;
        }


        while (aktiv) {

            int damage = combat.Angreb(min,max);

            System.out.println("Du svinger din " + weapon.getName() + " for " + damage + " skade.\n");

            System.out.println(creature.getNavn() + " har " + (hp = hp-damage) + " liv tilbage");


            if (hp < 1) {
                System.out.println("DØD");
                aktiv = false;

            }
            System.out.println("Vil du slå med din" + weapon.getName() + " igen\n1.Ja\n2.Nej)");
            int svar = main.in();

            switch (svar) {
                case 1:
                    System.out.println("\n så kører vi\n");
                    break;
                default:
                    aktiv = false;
                    System.out.println("[Godnat]");
            }
        }

        System.out.println("[Du skred");
    }

}
