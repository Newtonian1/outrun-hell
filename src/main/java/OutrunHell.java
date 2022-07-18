import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class OutrunHell {
    public static void main(String[] args) {
        //Generating player and npc
        Player player = new Player("Joe", 10, 4);
        player.setMoney(100);
        player.addToInventory("rtx 3090");
        player.addToInventory("rtx 3090");
        player.addToInventory("servo motor");
        player.addToInventory("rtx 3090");
        player.addToInventory("first aid kit");
        player.addToInventory("first aid kit");
        player.addToInventory("grenade");
        player.addToInventory("ancient scroll");
        player.addToInventory("ancient scroll");
        player.addToInventory("ancient scroll");
        NonPlayer npc1 = new NonPlayer("Freddy", 10, 2, 30, 0.5, "Tech Item", new String[]{"cool", "neat"}, "rtx 3090");

        //Event generation
        CharEvent event1 = new CharEvent("Start of event 1", "Conclusion to event 1");

        //Prompting and resolving player choice
        CharEvent.runCharEvent(event1, player, npc1);
    }

    public static void wait(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        }
        catch(InterruptedException ignored) {
        }
    }

    public static void print(String s) {
        if (s.equals("dividerLine")) {
            System.out.println("------------------------------------------------------------");
        } else {
            System.out.println(s);
        }
    }
}
