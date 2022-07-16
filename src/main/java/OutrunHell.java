import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class OutrunHell {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("...");
        wait(2);
        System.out.println("Hey, can you hear me?");
        wait(2);
        System.out.println("Nice to meet you, the name's Satan!");
        wait(2);
    }
    public static void wait(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        }
        catch(InterruptedException ignored) {

        }
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
