import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShopEvent extends Event {

    //CONSTRUCTOR
    public ShopEvent(String stageSettingText, String conclusionText) {
        super(stageSettingText, conclusionText);
    }

    //METHODS
    public static void generateShopItems(Map<String, Integer> itemPrices, int size) {
        int itemNumber;
        while(itemPrices.size() < size) {
            itemNumber = (int)(Math.random() * 10);
            if (itemNumber <= 1) {
                itemPrices.put("first aid kit", 40);
            } else if (itemNumber <= 3) {
                itemPrices.put("grenade", 50);
            } else if (itemNumber <= 5) {
                itemPrices.put("brass knuckles", 80);
            } else if (itemNumber == 6) {
                itemPrices.put("armored vest", 60);
            } else if (itemNumber == 7) {
                itemPrices.put("steroids", 125);
            } else if (itemNumber == 8) {
                itemPrices.put("health potion", 40);
            } else if (itemNumber == 9) {
                itemPrices.put("hell rocket", 50);
            }
        }
    }

    public static void printShop(Map<String, Integer> itemPrices) {
        int i = 1;
        OutrunHell.print("Items for sale:");
        OutrunHell.wait(1);
        for (Map.Entry<String, Integer> element : itemPrices.entrySet()) {
            OutrunHell.print(i + ") " + element.getKey() + ": $" + element.getValue());
            i++;
            OutrunHell.wait(1);
        }
        OutrunHell.print(" ");
        OutrunHell.print("dividerLine");
    }

    public static void selectItem(Map<String, Integer> itemPrices, Player player) {
        Scanner input = new Scanner(System.in);
        while (true) {
            printShop(itemPrices);
            OutrunHell.print("Player " + player.getName() + " has $" + player.getMoney() + ".");
            OutrunHell.print("Enter the name of an item to buy it or enter 0 to exit the shop:");
            String choice = input.nextLine().toLowerCase();
            if (itemPrices.containsKey(choice)) {
                int cost = itemPrices.get(choice);
                if (player.getMoney() >= cost) {
                    if (choice.equals("brass knuckles")) {
                        if (player.getHasBrassKnuckles()) {
                            OutrunHell.print(player.getName() + " already has brass knuckles.");
                            continue;
                        }
                        player.setMoney(player.getMoney() - cost);
                        player.setAttack(player.getAttack() + 1);
                        player.setHasBrassKnuckles(true);
                        OutrunHell.print(player.getName() + " purchased " + choice + " for $" + cost);
                        OutrunHell.print(player.getName() + " now has $" + player.getMoney());
                        OutrunHell.divider();
                        OutrunHell.print(player.getName() + "'s attack was increased!");
                        OutrunHell.print("dividerLine");
                    } else if (choice.equals("armored vest")) {
                        if (player.getHasArmoredVest()) {
                            OutrunHell.print(player.getName() + " already has armored vest.");
                            continue;
                        }
                        player.setMoney(player.getMoney() - cost);
                        player.setMaxHealth(player.getMaxHealth() + 2);
                        player.setHealth(player.getHealth() + 2);
                        player.setHasArmoredVest(true);
                        if (player.getHealth() > player.getMaxHealth()) {
                            player.setHealth(player.getMaxHealth());
                        }
                        OutrunHell.print(player.getName() + " purchased " + choice + " for $" + cost);
                        OutrunHell.print(player.getName() + " now has $" + player.getMoney());
                        OutrunHell.divider();
                        OutrunHell.print(player.getName() + "'s max health was increased!");
                        OutrunHell.print("dividerLine");
                    } else if (choice.equals("steroids")) {
                        player.setMoney(player.getMoney() - cost);
                        player.setAttack(player.getAttack() + 1);
                        player.setMaxHealth(player.getMaxHealth() + 2);
                        player.setHealth(player.getHealth() + 2);
                        if (player.getHealth() > player.getMaxHealth()) {
                            player.setHealth(player.getMaxHealth());
                        }
                        OutrunHell.print(player.getName() + " purchased " + choice + " for $" + cost);
                        OutrunHell.print(player.getName() + " now has $" + player.getMoney());
                        OutrunHell.divider();
                        OutrunHell.print(player.getName() + "'s attack and max health were increased!");
                        OutrunHell.print("dividerLine");
                    } else {
                        if (player.hasInventorySpace()) {
                            player.setMoney(player.getMoney() - cost);
                            player.addToInventory(choice);
                            OutrunHell.print(player.getName() + " purchased " + choice + " for $" + cost);
                            OutrunHell.print(player.getName() + " now has $" + player.getMoney());
                            OutrunHell.print("dividerLine");
                        } else {
                            OutrunHell.print("This item requires inventory space to purchase.");
                            OutrunHell.print("dividerLine");
                        }
                    }
                } else {
                    OutrunHell.print("You can't afford that item!");
                    OutrunHell.print("dividerLine");
                }
            } else if (choice.equals("0")) {
                return;
            } else {
                OutrunHell.print("Please enter a valid input");
                OutrunHell.print("dividerLine");
            }
        }
    }

    public static void runShopEvent(ShopEvent event, Player player) {
        OutrunHell.print(event.stageSettingText);
        OutrunHell.divider();
        int shopSize = 2 + (int)(Math.random() * 3);
        Map<String, Integer> shopItemPrices = new HashMap<>();
        generateShopItems(shopItemPrices, shopSize);
        selectItem(shopItemPrices, player);
        OutrunHell.print(event.conclusionText);
        OutrunHell.divider();
    }
}
