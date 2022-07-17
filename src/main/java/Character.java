abstract public class Character {
    protected String name;
    protected int maxHealth;
    protected int health;
    protected int attack;
    protected int money;

    //CONSTRUCTOR
    public Character(String name, int maxHealth, int attack, int money) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.health = maxHealth;
        this.money = money;
    }

    //SETTERS
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMoney() {
        return money;
    }
}
