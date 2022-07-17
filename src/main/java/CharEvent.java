import java.util.InputMismatchException;
import java.util.Scanner;

public class CharEvent extends Event {

    //CONSTRUCTOR
    public CharEvent(String stageSettingText, String conclusionText) {
        super(stageSettingText, conclusionText);
    }

    //STATIC METHODS
    public static PlayerChoice promptPlayer() {
        //Try block implemented to contain and auto-close Scanner
        Scanner input = new Scanner(System.in);
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

    //ATTACK METHODS
    public void attackAndDeathCheck(Character attacker, Character target) {
        target.setHealth(target.getHealth() - attacker.getAttack());
        if (target.getHealth() <= 0) {
            OutrunHell.print(target.getName() + " was defeated by " + attacker.getName() + ".");
        } else {
            OutrunHell.print(attacker.getName() + " dealt " + attacker.getAttack() + " to " + target.getName() + ".");
            OutrunHell.print(target.getName() + " now has " + target.getHealth() + " health left.");
        }
    }
    //Returns true for dead and false for not dead

    public void nonPlayerKilled(Player player, NonPlayer non) {
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

    public static void playerKilledMessage() {
        OutrunHell.print("GAME OVER");
        OutrunHell.print("Thank you for playing");
        OutrunHell.print("--------------------------------------------");
        OutrunHell.print("Game created by: Joe Ross");
        OutrunHell.print("Special thanks to: Ryan Slama");
    }

    //BRIBE METHODS
    public boolean tryBribe(Player player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how much money to bribe:");
        while (true) {
            String stringBribe = input.nextLine();
            int bribe;
            try {
                bribe = Integer.parseInt(stringBribe);
            } catch (InputMismatchException e) {
                OutrunHell.print("Please enter a valid number");
                continue;
            }
            if (bribe > 0 && bribe <= player.getMoney()) {
                int bribeNeeded = (int) (Math.random() * 100);
                if (bribe >= bribeNeeded) {
                    OutrunHell.print("The bribe has been accepted!");
                    player.setMoney(player.getMoney() - bribe);
                    return true;
                } else {
                    OutrunHell.print("The bribe was denied...");
                    return false;
                }
            } else {
                OutrunHell.print("Please enter a valid number");
            }
        }

    }
    //Either accepts the bribe (return true, money subtracted) or rejects bribe (return false)

    //ENUMS
    public enum PlayerChoice {
        ATTACK,
        BRIBE,
        WOO,
        BAG
    }
}
