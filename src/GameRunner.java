
public class GameRunner {

    public void start() {
        boolean programRunning = true;
        Main main = new Main();
        Creature creature = Creature.creature(0);
        Combat combat = new Combat();
        Character character = new Character();
        character.gemWeaponList();
        int wp = 0;
        Weapon weapon = character.egedeVåben.get(0);
        //Weapon weapon = character.equipWeapon(wp);
        character.setHealth(100);

        while (programRunning) {
            programRunning = mainMenu(main, creature, combat, character, weapon, wp);
        }
    }

    public boolean mainMenu(Main main, Creature creature, Combat combat, Character character, Weapon weapon, int wp) {
        System.out.println("Velkommen til spillet");
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
                    Spil(main, creature, combat, character, weapon, wp);

                break;
            case 2:
                Character(main, creature, combat, character, weapon);
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

    public int Spil(Main main, Creature creature, Combat combat, Character character, Weapon weapon, int wp) {
        boolean aktiv = true;
        boolean igen = true;

        /*System.out.println("Vælg våben");
        int vaaben = main.in();
        weapon = character.equipWeapon(vaaben);*/
        //Character skade
        int pMin = weapon.getMin();
        int pMax = weapon.getMax();
        //Creature skade
        int cMin = creature.getMin();
        int cMax = creature.getMax();
        int creatureHp = creature.getHp();

        System.out.println("En " + creature.getNavn().toLowerCase() + " dukkede op bag et træ");

        System.out.println("Vil du kæmpe mod den?\n1. Ja\n2. Nej");
        int kamp = main.in();
        if (kamp == 1) {
        } else {
            System.out.println("Du flygtede.");
            aktiv = false;
        }
        while (aktiv) {
            int charDamage = combat.Angreb(pMin, pMax);

            System.out.println("Du svinger din " + weapon.getName().toLowerCase() + " for " + charDamage + " skade.\n");
            creatureHp = creatureHp - charDamage;
            System.out.println(creature.getNavn().toLowerCase() + " har " + creatureHp + " liv tilbage\n");


            if (creatureHp < 1) {
                System.out.println(creature.getNavn() + " døde");
                wp++;
                creature = Creature.creature(1);
                aktiv = false;
                igen = false;
            } else {
                igen = true;
            }


            while (igen) {
                int creaDamage = combat.Angreb(cMin, cMax);
                int characterhp = character.getHealth();

                System.out.println(creature.getNavn() + " angriber dig for" + creaDamage + " skade.\n");
                characterhp = characterhp - creaDamage;
                System.out.println(character.getNavn() + " har " + characterhp + " liv tilbage\n");
                character.setHealth(characterhp);

                System.out.println("Vil du slå med din " + weapon.getName().toLowerCase() + " igen\n1.Ja\n2.Nej)");
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
        return wp;
    }

    public void Character(Main main, Creature creature, Combat combat, Character character, Weapon weapon) {
        System.out.println("Hvad vil du se?");
        System.out.println("1. Se Våben");
        System.out.println("2. Se liv");
        System.out.println("0. Tilbage");
        int svar = main.in();

        switch (svar) {
            case 0:
                break;
            case 1:

                System.out.println("Du bærer:\n"+weapon+"\n");
                break;
            case 2:
                System.out.println("Du har "+character.getHealth()+" liv.");
                break;
        }
    }

}
