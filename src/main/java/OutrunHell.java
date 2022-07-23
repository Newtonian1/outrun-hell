import java.util.*;
import java.util.concurrent.TimeUnit;


public class OutrunHell {
    public static void main(String[] args) {
        //Welcome
        OutrunHell.print("Welcome to Outrun Hell!");
        OutrunHell.divider();
        OutrunHell.print("You have been wrongfully sent to the place where the baddies go.");
        OutrunHell.divider();
        OutrunHell.print("Now it's up to you to escape. But there may be some strange characters in your way.");
        OutrunHell.divider();
        OutrunHell.print("Best of luck!");
        OutrunHell.divider();

        //npcDeck generation
        List<String> npcDeck = new ArrayList<>();
        npcDeck.add("Tobey Maguire");
        npcDeck.add("Caligula");
        npcDeck.add("Adolf");
        npcDeck.add("Vlad");
        npcDeck.add("Genghis Khan");
        npcDeck.add("Queen Mary");
        npcDeck.add("Azula");
        npcDeck.add("Thanos");
        npcDeck.add("Joker");
        Collections.shuffle(npcDeck);

        //Generating player
        Player player;
        player = new Player("", 10, 4);
        player.addToInventory("first aid kit");
        player.addToInventory("pipe bomb");
        player.setPlayerName();

        //npc and event set up
        NonPlayer npc;
        CharEvent event;
        ShopEvent shop = new ShopEvent("It looks like a Meta-Amazon-Apple all purpose retail store is up ahead!", "Wow, the prices there were way better than they were at the Microsoft-Google center! They didn't even charge an existence tax!");
        int shopIndex = 2 + (int)(Math.random() * 2);

        //Run events
        for (int i = 0; i < 7; i++) {
            npc = NonPlayer.genNonPlayer(npcDeck.get(i));
            event = CharEvent.genCharEvent(i);
            CharEvent.runCharEvent(event, player, npc);
            if (i == shopIndex) {
                ShopEvent.runShopEvent(shop, player);
            }
        }

        //Winning
        OutrunHell.print("Congrats! You escaped from Hell. You beat the game!");
        OutrunHell.print("Thank you for playing");
        OutrunHell.print("--------------------------------------------");
        OutrunHell.print("Game created by: Joe Ross");
        OutrunHell.print("Special thanks to: Ryan Slama");
        OutrunHell.wait(10);
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
