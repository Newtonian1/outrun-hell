import java.util.Scanner;

public class CharEvent {
    public static playerChoice promptPlayer() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("What do?");
            System.out.println("1: Attack");
            System.out.println("2: Bribe");
            System.out.println("3: Woo");
            System.out.println("4: Bag");
            while (true) {
                if (input.hasNextInt()) {
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            return playerChoice.ATTACK;
                        case 2:
                            return playerChoice.BRIBE;
                        case 3:
                            return playerChoice.WOO;
                        case 4:
                            return playerChoice.BAG;
                        default:
                            break;
                    }
                } else {
                    input.next();
                }
                System.out.println("Please input a number between 1 and 4");
            }
        }
    }

    enum playerChoice {
        ATTACK,
        BRIBE,
        WOO,
        BAG
    }
}
