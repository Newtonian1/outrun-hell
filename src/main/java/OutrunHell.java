import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class OutrunHell {
    public static void main(String[] args) {
        Character player = new Player("Joe", 10, 3);
        Event event1 = new CharEvent("String1", "String2");
        print(CharEvent.promptPlayer().toString());
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
