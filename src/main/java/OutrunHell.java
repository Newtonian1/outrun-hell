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
        itemMap.put("fiji water", "Heal Item");

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
