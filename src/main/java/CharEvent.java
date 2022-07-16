import java.util.Scanner;

public class CharEvent extends Event {

    public CharEvent(String stageSettingText, String conclusionText) {
        super(stageSettingText, conclusionText);
    }

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

    public enum PlayerChoice {
        ATTACK,
        BRIBE,
        WOO,
        BAG
    }
}
