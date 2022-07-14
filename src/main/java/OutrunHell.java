import java.util.Scanner;

public class OutrunHell {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a word to have it repeated back to you:");
        String input1 = userInput.nextLine();
        System.out.println(input1);
    }
}
