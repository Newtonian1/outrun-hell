import java.util.List;
import java.util.ArrayList;

public class Player extends Character {
    private List<String> inventory = new ArrayList<>();
    private int maxInventory = 12;

    private boolean hasBrassKnuckles = false;

    private boolean hasArmoredVest = false;

    //CONSTRUCTOR
    public Player(String name, int maxHealth, int attack) {
        super(name, maxHealth, attack, 50);
    }

    //INVENTORY MANAGEMENT
    public void printInventory() {
        int i = 1;
        OutrunHell.print("Items in bag:");
        for (String item : inventory) {
            System.out.print(i + ") " + item + "   ");
            if (i % 4 == 0) {
                OutrunHell.print(" ");
            }
            i++;
        }
        OutrunHell.print(" ");
        OutrunHell.print("dividerLine");
    }

    public boolean getHasBrassKnuckles() {
        return hasBrassKnuckles;
    }

    public void setHasBrassKnuckles(boolean hasBrassKnuckles) {
        this.hasBrassKnuckles = hasBrassKnuckles;
    }

    public boolean getHasArmoredVest() {
        return hasArmoredVest;
    }

    public void setHasArmoredVest(boolean hasArmoredVest) {
        this.hasArmoredVest = hasArmoredVest;
    }

    public int getInventorySize(){
        return inventory.size();
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

    public String selectItem (int itemChoice) {
        return inventory.get(itemChoice - 1);
    }
}
