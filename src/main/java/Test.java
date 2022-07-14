import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int enemyHealth = 10;
        while (enemyHealth > 0) {
            System.out.println("Select an action by typing the number before it:");
            OutrunHell.wait(1);
            System.out.println("1 - Attack");
            System.out.println("2 - Bribe");
            System.out.println("3 - Woo");
            System.out.println("4 - Inventory");
            int userAction = userInput.nextInt();
            if (userAction == 1) {
                System.out.println("Yoooowch that hurt! I'll get you for that...");
                enemyHealth -= 3;
            } else if (userAction == 3) {
                if (Math.random() > 0.8) {
                    break;
                } else {
                    System.out.println("You can't win me over!");
                }
            } else {
                System.out.println("You're going down buddy.");
            }
        }
        System.out.println("Battle won!");
    }
}
