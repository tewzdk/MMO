public class Character {
    private String navn;
    private int health;
    private int armor;

    public static Weapon equipWeapon(int svar) {
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
}
