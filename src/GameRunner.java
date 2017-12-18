import java.util.Random;
import java.util.Scanner;

public class GameRunner {

    public void start() {
        Character character = new Character();
        character.laesWeaponList();
        character.laesHealth();
        boolean programRunning = true;
        Main main = new Main();
        Creature creature = Creature.creature(character.getCreature());
        Weapon weapon = character.weapons(character.getEquippedWeapon());

        while (programRunning) {
            programRunning = mainMenu(main, creature, character, weapon);
        }
    }

    public boolean mainMenu(Main main, Creature creature, Character character, Weapon weapon) {
        weapon = character.weapons(character.getEquippedWeapon());
        creature = Creature.creature(character.getCreature());
        System.out.println("Velkommen til spillet " + character.getNavn() + "!");
        System.out.println("1. Prøv Spil");
        System.out.println("2. Se din karakter");
        System.out.println("0. Afslut spillet");
        boolean aktiv;
        int svar = main.in();
        switch (svar) {
            case 0:
                System.out.println("[Spillet afsluttes]");
                return false;
            case 1:
                Spil(main, creature, character, weapon);

                break;
            case 2:
                Character(main, creature, character, weapon);
                break;
            case 3:
                aktiv = true;
                while (aktiv) {

                }
                break;
            case 4:

                break;
            default:
                System.out.println("'" + svar + "' er ikke et korrekt valg");
        }


        return true;
    }

    public void Spil(Main main, Creature creature, Character character, Weapon weapon) {

        boolean aktiv = true;
        boolean igen = true;

        //Character skade
        int pMin = weapon.getMin();
        int pMax = weapon.getMax();
        //Creature skade
        int cMin = creature.getMin();
        int cMax = creature.getMax();
        int creatureHp = creature.getHp();

        Random scenarie = new Random();

        int randomscenario = scenarie.nextInt(5);
        switch (randomscenario) {
            case 0:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag et træ");
                break;
            case 1:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag en sten");
                break;
            case 2:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag et hus");
                break;
            case 3:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag en bakke");
                break;
            case 4:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag et skilt");
                break;
            case 5:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag et skur");
                break;
            default:
                System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag et skur");
                break;
        }

        System.out.println("Vil du kæmpe mod den?\n1. Ja\n2. Nej");
        int kamp = main.in();
        if (kamp == 1) {
        } else {
            System.out.println("Du flygtede.");
            aktiv = false;
        }
        while (aktiv) {
            int charDamage = character.Angreb(pMin, pMax);

            System.out.println("Du svinger din " + weapon.getName().toLowerCase() + " for " + charDamage + " skade.");
            creatureHp = creatureHp - charDamage;
            System.out.println(creature.getNavn().toLowerCase() + " har " + creatureHp + " liv tilbage");


            if (creatureHp < 1) {
                character.setLoot((character.getLoot() + 1));

                System.out.println("Du besejrede " + creature.getNavn() +
                        " og fandt en " + character.weapons(character.getLoot()) +
                        " inde i " + creature.getNavn().toLowerCase() + "\nDu lagde den i din taske.\n");

                character.setCreature((character.getCreature() + 1));
                character.egedeVåben.add(character.getLoot());
                character.gemWeaponList();
                aktiv = false;
                igen = false;
            } else {
                igen = true;
            }

            while (igen) {
                int creaDamage = character.Angreb(cMin, cMax);
                int characterhp = character.getHealth();
                System.out.print("");
                System.out.println(creature.getNavn() + " angriber dig for " + creaDamage + " skade.");
                characterhp = characterhp - creaDamage;
                System.out.println(character.getNavn() + " har " + characterhp + " liv tilbage\n");
                character.setHealth(characterhp);
                character.gemHealth();

                System.out.println("Vil du slå med din " + weapon.getName().toLowerCase() + " igen\n1.Ja\n2.Nej");
                int svar = main.in();

                switch (svar) {
                    case 1:
                        break;
                    default:
                        aktiv = false;
                        System.out.println("Du flygtede.");
                }
                igen = false;
            }
        }
        System.out.println("");
    }

    public void Character(Main main, Creature creature, Character character, Weapon weapon) {
        boolean fedt = true;
        while (fedt) {
            System.out.println("Hvad vil du se?");
            System.out.println("1. Se Kriger");
            System.out.println("2. Se dine våben");
            System.out.println("3. Skift Våben");
            System.out.println("4. Sælg våben");
            System.out.println("5. Køb liv");
            System.out.println("6. Skift navn");
            System.out.println("0. Tilbage");
        boolean skiftVaaben = true;
        int svar = main.in();


        switch (svar) {
            case 0:
                fedt = false;
                break;
            case 1:
                System.out.println("------------------------------");
                System.out.println("Navn: " + character.getNavn());
                System.out.println("Liv: " + character.getHealth());
                System.out.println("Våben: " + weapon);
                System.out.println("------------------------------");
                System.out.print("\nTryk ENTER for at gå videre ");
                String videre = main.inputString();
                System.out.println();
                break;
            case 2:
                for (int i = 0; i < character.egedeVåben.size(); i++) {
                    System.out.println(character.weapons(character.egedeVåben.get(i)));
                }
                System.out.print("\nTryk ENTER for at gå videre ");
                videre = main.inputString();
                System.out.println();
                break;
            case 3:
                while (skiftVaaben) {
                    System.out.println("Vælg nyt våben");
                    int tal = -1;
                    for (int i = 0; i < character.egedeVåben.size(); i++) {
                        tal = tal + 1;
                        System.out.print("[" + tal + ". " + character.weapons(character.egedeVåben.get(i)).getName() + "] ");
                    }
                    System.out.println("");
                    int spg = main.in();
                    for (int i = 0; i < character.egedeVåben.size(); i++) {
                        if (spg == character.egedeVåben.get(i)) {
                            character.setEquippedWeapon(spg);
                            character.gemHealth();
                            skiftVaaben = false;
                        }

                    }
                }
                break;
            case 4:
                System.out.println("Hvad vil du sælge?");

                int spg = main.in();
                for (int i = 0; i < character.egedeVåben.size(); i++) {
                    if (spg == character.egedeVåben.get(i)) {
                        character.setGold(character.getGold() + 10);
                        System.out.println(character.getGold());
                        character.egedeVåben.remove(i);
                        System.out.println("Du solgte en" + character.weapons(i) + " for 10 guld.");
                    }
                }

                break;
            case 5:
                System.out.println("Vil du hele dit liv ?");
                System.out.println("1. Ja");
                System.out.println("2. Nej");

                int healsvar = main.in();

                if (healsvar == 1) {
                    boolean guld = true;
                    while (guld) {
                        if (character.getGold() > 10) {
                            if (character.getHealth() < 100){
                                character.setHealth(character.getHealth() + 20);
                                if (character.getHealth() > 100){
                                    character.setHealth(100);
                                }
                            } else {
                                guld = false;
                            }
                        } else {
                            System.out.println("Du har ikke mere guld.");
                            guld = false;
                        }
                    }
                }

                break;
            case 6:
                System.out.println("Hvad er dit navn?");
                Scanner scanner = new Scanner(System.in);
                String navn = scanner.next();
                character.setNavn(navn);
                character.gemHealth();
                fedt = false;
                break;
        }
    }
    }
}
