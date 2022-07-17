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
            System.out.print(item + "   ");
        }
    }

    public boolean hasInventorySpace() {
        return inventory.size() < maxInventory;
    }

    public void addToInventory(String item) {
            inventory.add(item);
    }

    public void removeFromInventory(String item) {
        inventory.remove(item);
    }
}
