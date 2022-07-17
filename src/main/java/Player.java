import java.util.List;
import java.util.ArrayList;

public class Player extends Character {
    private List<String> inventory = new ArrayList<>();
    private int maxInventory = 12;

    //CONSTRUCTOR
    public Player(String name, int maxHealth, int attack) {
        super(name, maxHealth, attack, 0);
    }

    //INVENTORY MANAGEMENT
    public void printInventory() {
        OutrunHell.print("Items in bag:");
        for (String item : inventory) {
            System.out.print(item + " ");
        }
    }

    public boolean addToInventory(String item) {
        if (inventory.size() < maxInventory) {
            inventory.add(item);
            return true;
        }
        return false;
    }

    public boolean removeFromInventory(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            return true;
        }
        return false;
    }

}
