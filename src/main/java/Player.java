import java.util.List;
import java.util.ArrayList;

public class Player extends Character{
    private List<String> inventory = new ArrayList<>();


    public Player(String name, int maxHealth, int attack) {
        super(name, maxHealth, attack, 0);
    }
}
