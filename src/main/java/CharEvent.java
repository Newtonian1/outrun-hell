import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharEvent extends Event {

    //CONSTRUCTORS
    public CharEvent(String stageSettingText, String conclusionText) {
        super(stageSettingText, conclusionText);
    }

    public CharEvent(){}

    //STATIC METHODS
    public static CharEvent genCharEvent(int eventNumber) {
        CharEvent event = new CharEvent();
        switch (eventNumber) {
            case 0:
                event.stageSettingText = "Start of event 1";
                event.conclusionText = "End of event 1";
                break;
            case 1:
                event.stageSettingText = "Start of event 2";
                event.conclusionText = "End of event 2";
                break;
            case 2:
                event.stageSettingText = "Start of event 3";
                event.conclusionText = "End of event 3";
                break;
            case 3:
                event.stageSettingText = "Start of event 4";
                event.conclusionText = "End of event 4";
                break;
            case 4:
                event.stageSettingText = "Start of event 5";
                event.conclusionText = "End of event 5";
                break;
            case 5:
                event.stageSettingText = "Start of event 6";
                event.conclusionText = "End of event 6";
                break;
            case 6:
                event.stageSettingText = "Start of event 7";
                event.conclusionText = "End of event 7";
                break;
            default:
                break;
        }
        return event;
    }

    public static PlayerChoice promptPlayer() {
        Scanner input = new Scanner(System.in);
        OutrunHell.print("Type a number and hit enter to select an action:");
        OutrunHell.print("1: Attack");
        OutrunHell.print("2: Bribe");
        OutrunHell.print("3: Woo");
        OutrunHell.print("4: Bag");
        while (true) {
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    return PlayerChoice.ATTACK;
                case "2":
                    return PlayerChoice.BRIBE;
                case "3":
                    return PlayerChoice.WOO;
                case "4":
                    return PlayerChoice.BAG;
                default:
                    break;
            }
            OutrunHell.print("Please input a number between 1 and 4");
        }
    }

    //ATTACK METHODS
    public void attackAndDeathCheck(Character attacker, Character target) {
        target.setHealth(target.getHealth() - attacker.getAttack());
        if (target.getHealth() <= 0) {
            OutrunHell.print(attacker.getName() + " dealt " + attacker.getAttack() + " to " + target.getName() + ".");
            OutrunHell.print(target.getName() + " now has 0 health left.");
            OutrunHell.divider();
            OutrunHell.print(target.getName() + " was defeated by " + attacker.getName() + ".");
            OutrunHell.divider();
        } else {
            OutrunHell.print(attacker.getName() + " dealt " + attacker.getAttack() + " to " + target.getName() + ".");
            OutrunHell.print(target.getName() + " now has " + target.getHealth() + " health left.");
        }
    }
    //Returns true for dead and false for not dead

    public void nonPlayerKilled(Player player, NonPlayer non) {
        player.setMoney(player.getMoney() + non.getMoney());
        OutrunHell.print(non.getName() + " had $" + non.getMoney() + ". Finders keepers!");
        OutrunHell.print(player.getName() + " now has $" + player.getMoney() + ".");
        if (non.getRewardItem().equals("none")) {
            return;
        }
        OutrunHell.divider();
        if (player.hasInventorySpace()) {
            player.addToInventory(non.getRewardItem());
            OutrunHell.print(non.getName() + " had " + non.getRewardItem() + " in their inventory, so " + player.getName() + " picked it up.");
        } else {
            OutrunHell.print("Player inventory is full, so " + non.getRewardItem() + " was left behind.");
        }
    }

    public static void playerKilledMessage() {
        OutrunHell.print("GAME OVER");
        OutrunHell.print("Thank you for playing");
        OutrunHell.print("--------------------------------------------");
        OutrunHell.print("Game created by: Joe Ross");
        OutrunHell.print("Special thanks to: Ryan Slama");
        OutrunHell.wait(10);
        System.exit(0);
    }

    //BRIBE METHODS
    public boolean tryBribe(Player player) {
        Scanner input = new Scanner(System.in);
        OutrunHell.print("Enter how much money to bribe:");
        while (true) {
            String stringBribe = input.nextLine();
            int bribe;
            try {
                bribe = Integer.parseInt(stringBribe);
            } catch (Exception e) {
                OutrunHell.print("Please enter a valid number");
                continue;
            }
            if (bribe > 0 && bribe <= player.getMoney()) {
                OutrunHell.print(player.getName() + " offered a bribe of $" + bribe + ".");
                OutrunHell.divider();
                int bribeNeeded = (int)(Math.random() * 100) + 1;
                if (bribe >= bribeNeeded) {
                    OutrunHell.print("The bribe was accepted!");
                    player.setMoney(player.getMoney() - bribe);
                    return true;
                } else {
                    OutrunHell.print("The bribe was rejected. Better luck next time...");
                    return false;
                }
            } else {
                OutrunHell.print("Please enter a valid number");
            }
        }

    }
    //Either accepts the bribe (return true, money subtracted) or rejects bribe (return false)


    //WOO METHODS
    public boolean tryWoo(NonPlayer non) {
        double woo = Math.random();
        return woo >= non.getWooMin();
    }

    //BAG METHODS
    public String openBag(Player player, NonPlayer non) {
        player.printInventory();
        Scanner input = new Scanner(System.in);
        OutrunHell.print("Select an item to use by typing the number in front of it, or press 0 to close the bag:");
        while (true) {
            String itemChoice = input.nextLine();
            int itemInt;
            try {
                itemInt = Integer.parseInt(itemChoice);
            } catch (Exception e) {
                OutrunHell.print("Please enter a valid number");
                continue;
            }
            if (itemInt > 0 && itemInt <= player.getInventorySize()) {
                String itemName = player.selectItem(itemInt);
                String itemType = getItemType(itemName);
                if (itemType.equals("Heal Item") && player.getHealth() == player.getMaxHealth()) {
                    OutrunHell.print("Item cannot be used (Player is already at full health).");
                    OutrunHell.divider();
                    return "close";
                }
                if (itemType.equals("Damage Item") || itemType.equals("Heal Item")) {
                    useItem(itemName, itemType, player, non);
                    player.removeFromInventory(itemName);
                    return "used";
                } else {
                    if (itemType.equals(non.getFavItemType())) {
                        OutrunHell.print(non.getName() + " accepted the item!");
                        player.removeFromInventory(itemName);
                        return "given";
                    } else {
                        OutrunHell.print(non.getName() + " doesn't seem interested in that item.");
                        return "rejected";
                    }
                }
            } else if (itemInt == 0) {
                return "close";
            } else {
                OutrunHell.print("Please enter a valid number");
            }
        }
    }

    public static String getItemType(String item) {
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
        return itemMap.get(item);
    }

    public void useItem(String itemName, String itemType, Player player, NonPlayer non) {
        switch (itemType) {
            case "Damage Item":
                non.setHealth(non.getHealth() - 8);
                int healthLeft = non.getHealth();
                if (healthLeft < 0) {
                    healthLeft = 0;
                }
                OutrunHell.print("The " + itemName + " did 8 damage to " + non.getName() + "!");
                OutrunHell.print(non.getName() + " now has " + healthLeft + " health left.");
                if (healthLeft == 0) {
                    OutrunHell.divider();
                    OutrunHell.print(non.getName() + " was defeated by " + player.getName() + ".");
                    OutrunHell.divider();
                }
                break;
            case "Heal Item":
                player.setHealth(player.getHealth() + (player.getMaxHealth() / 2));
                if (player.getHealth() > player.getMaxHealth()) {
                    player.setHealth(player.getMaxHealth());
                }
                OutrunHell.print(player.getName() + " was healed and now has " + player.getHealth() + " health.");
                break;
            default:
                break;
        }
    }

    //ENUMS
    public enum PlayerChoice {
        ATTACK,
        BRIBE,
        WOO,
        BAG
    }

    //RUN CHARACTER EVENT METHOD
    public static void runCharEvent(CharEvent event, Player player, NonPlayer npc) {
        OutrunHell.print(event.stageSettingText);
        OutrunHell.divider();
        OutrunHell.print(npc.getIntroText());
        OutrunHell.divider();
        OutrunHell.wait(2);
        OutrunHell.print(player.getName() + " has " + player.getHealth() + " health and $" + player.getMoney() + ".");
        OutrunHell.divider();
        while (true) {
            String playerChoice = CharEvent.promptPlayer().toString();
            if (playerChoice.equals("ATTACK")) {
                event.attackAndDeathCheck(player, npc);
                if(npc.getHealth() <= 0) {
                    event.nonPlayerKilled(player, npc);
                    break;
                }
            } else if (playerChoice.equals("BRIBE")) {
                OutrunHell.print("Player money: $" + player.getMoney());
                if(event.tryBribe(player)) {
                    OutrunHell.print("Player money left: $" + player.getMoney());
                    break;
                }
            } else if (playerChoice.equals("WOO")) {
                OutrunHell.print(player.getName() + " tried to sweet-talk " + npc.getName() + ".");
                if(event.tryWoo(npc)) {
                    OutrunHell.print(player.getName() + " successfully won " + npc.getName() + " over!");
                    break;
                }
                OutrunHell.print(npc.getName() + " was not impressed by the attempted flattery.");
            } else if (playerChoice.equals("BAG")) {
                String bagResult = event.openBag(player, npc);
                if (bagResult.equals("close")) {
                    continue;
                } else if (bagResult.equals("given")) {
                    break;
                }
                if(npc.getHealth() <= 0) {
                    event.nonPlayerKilled(player, npc);
                    break;
                }
            }
            OutrunHell.divider();
            event.attackAndDeathCheck(npc, player);
            OutrunHell.divider();
            if (player.getHealth() <= 0) {
                CharEvent.playerKilledMessage();
                //Quit program
                break;
            }
            OutrunHell.print(npc.getName() + ": " + npc.getCatchPhrase());
            OutrunHell.divider();
        }
        OutrunHell.divider();
        OutrunHell.print(event.conclusionText);
        OutrunHell.divider();
        OutrunHell.wait(2);
    }
}
