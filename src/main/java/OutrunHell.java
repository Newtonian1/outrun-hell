import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class OutrunHell {
    public static void main(String[] args) {
        //Generating player and npc
        Player player;
        player = new Player("Joe", 10, 4);
        player.addToInventory("rtx 3090");
        player.addToInventory("first aid kit");
        player.addToInventory("grenade");
        NonPlayer npc;
        npc = new NonPlayer("Freddy", 10, 2, 30, 0.5, "Tech Item", new String[]{"cool", "neat"}, "rtx 3090");

        //Event generation
        ShopEvent shop = new ShopEvent("Shop event alert!", "End of shop event");
        CharEvent event = new CharEvent("Start of event 1", "Conclusion to event 1");

        //Prompting and resolving player choice
        ShopEvent.runShopEvent(shop, player);
        CharEvent.runCharEvent(event, player, npc);
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

    public static void divider() {
        print("dividerLine");
        wait(2);
    }
}
