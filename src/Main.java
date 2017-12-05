import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean aktiv = true;
        Combat combat = new Combat();
        Scanner in = new Scanner(System.in);
        Creature creature = Creature.creature(0);
        Character character = new Character();

        System.out.println("Vælg våben");
        int vaaben = in.nextInt();
        Weapon weapon = character.equipWeapon(vaaben);
        int min = weapon.getMin();
        int max = weapon.getMax();

        System.out.println("En " + creature.getNavn() + " dukkede op bag et træ");
        int hp = creature.getHp();

        System.out.println("Vil du kæmpe mod den?\n1. Ja\n2. Nej");
        int kamp = in.nextInt();
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
            int svar = in.nextInt();

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
