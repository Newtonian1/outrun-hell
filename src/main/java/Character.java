abstract public class Character {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int attack;
    protected int money;

    public Character(String name, int maxHealth, int attack, int money) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.health = maxHealth;
        this.money = money;
    }
}
