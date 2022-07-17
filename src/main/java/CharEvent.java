import java.util.Scanner;

public class CharEvent extends Event {

    //CONSTRUCTOR
    public CharEvent(String stageSettingText, String conclusionText) {
        super(stageSettingText, conclusionText);
    }

    //STATIC METHODS
    public static PlayerChoice promptPlayer() {
        //Try block implemented to contain and auto-close Scanner
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("What do?");
            System.out.println("1: Attack");
            System.out.println("2: Bribe");
            System.out.println("3: Woo");
            System.out.println("4: Bag");
            while (true) {
                String choice = input.nextLine();
                switch (choice) {
                    case "1":
                        return PlayerChoice.ATTACK;
                    case "2":
                        return PlayerChoice.BRIBE;
                    case "3":
                        return PlayerChoice.WOO;
                    case "4":
                        return PlayerChoice.BAG;
                    default:
                        break;
                }
                System.out.println("Please input a number between 1 and 4");
            }
        }
    }
    //ATTACK METHODS
    public boolean attackAndDeathCheck (Character attacker, Character target) {
        target.setHealth(target.getHealth() - attacker.getAttack());
        if (target.getHealth() <= 0) {
            OutrunHell.print(target.getName() + " was defeated by " + attacker.getName() + ".");
            return true;
        } else {
            OutrunHell.print(attacker.getName() + " dealt " + attacker.getAttack() + " to " + target.getName() + ".");
            OutrunHell.print(target.getName() + " now has " + target.getHealth() + " health left.");
            return false;
        }
    }
    //Returns true for dead and false for not dead

    public void nonPlayerKilled(NonPlayer non, Player player) {
        if (non.getRewardItem().equals("none")) {
            return;
        }
        if (player.hasInventorySpace()) {
            player.addToInventory(non.getRewardItem());
            OutrunHell.print(player.getName() + " received " + non.getRewardItem() + " as a reward.");
        } else {
            OutrunHell.print("Player inventory is full, so " + non.getRewardItem() + " was left behind.");
        }
    }

    public void playerKilledMessage() {
        OutrunHell.print("GAME OVER");
        OutrunHell.print("Thank you for playing");
        OutrunHell.print("--------------------------------------------");
        OutrunHell.print("Game created by: Joe Ross");
        OutrunHell.print("Special thanks to: Ryan Slama");
    }
    //BRIBE METHODS

    //ENUMS
    public enum PlayerChoice {
        ATTACK,
        BRIBE,
        WOO,
        BAG
    }
}
