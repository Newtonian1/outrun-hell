import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class OutrunHell {
    public static void main(String[] args) {
        //Item Map Generation

        Map<String, String> itemMap = new HashMap<>();
        itemMap.put("grenade", "Damage Item");
        itemMap.put("dynamite", "Damage Item");
        itemMap.put("pipe bomb", "Damage Item");
        itemMap.put("hell rocket", "Damage Item");

        itemMap.put("first aid kit", "Heal Item");
        itemMap.put("health potion", "Heal Item");

        itemMap.put("claw fossil", "Artifact Item");
        itemMap.put("ancient scroll", "Artifact Item");
        itemMap.put("egyptian scarab", "Artifact Item");
        itemMap.put("stone tablet", "Artifact Item");

        itemMap.put("rolex watch", "Valuable Item");
        itemMap.put("pearl necklace", "Valuable Item");
        itemMap.put("gold ring", "Valuable Item");
        itemMap.put("black diamond", "Valuable Item");

        itemMap.put("flash drive", "Tech Item");
        itemMap.put("microchip", "Tech Item");
        itemMap.put("rtx 3090", "Tech Item");
        itemMap.put("servo motor", "Tech Item");

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
        player.printInventory();
        NonPlayer npc = new NonPlayer("Freddy", 10, 2, 30, 0.5, "Tech Item", new String[]{"cool", "neat"}, "rtx 3090");

        //Event generation
        CharEvent event1 = new CharEvent("String1", "String2");
        OutrunHell.print(npc.getName() + " wants to fight!");
        OutrunHell.wait(2);
        OutrunHell.print(player.getName() + " has " + player.getHealth() + " health and $" + player.getMoney() + ".");
        OutrunHell.wait(2);

        //Prompting and resolving player choice
        while (true) {
            String playerChoice = CharEvent.promptPlayer().toString();
            if (playerChoice.equals("ATTACK")) {
                event1.attackAndDeathCheck(player, npc);
                if(npc.getHealth() <= 0) {
                    event1.nonPlayerKilled(player, npc);
                    break;
                }
            } else if (playerChoice.equals("BRIBE")) {
                OutrunHell.print("Player money: $" + player.getMoney());
                if(event1.tryBribe(player)) {
                    OutrunHell.print("Player money left: $" + player.getMoney());
                    break;
                }
            } else if (playerChoice.equals("WOO")) {
                OutrunHell.print(player.getName() + " tried to sweet-talk " + npc.getName() + ".");
                if(event1.tryWoo(npc)) {
                    OutrunHell.print(player.getName() + " successfully won " + npc.getName() + " over!");
                    break;
                }
                OutrunHell.print(npc.getName() + " was not impressed by the attempted flattery.");
            } else if (playerChoice.equals("BAG")) {
                player.printInventory();
            }
            OutrunHell.wait(2);
            event1.attackAndDeathCheck(npc, player);
            OutrunHell.wait(2);
            if (player.getHealth() <= 0) {
                CharEvent.playerKilledMessage();
                //Quit program
                break;
            }
        }
        OutrunHell.print("end");
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
