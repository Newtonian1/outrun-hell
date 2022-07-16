public class NonPlayer extends Character{
    private double wooMin;
    private double greed;
    private String favItemType;
    private String rewardItem;

    public NonPlayer(String name, int maxHealth, int attack, int money, double wooMin, double greed, String favItemType, String rewardItem) {
        super(name, maxHealth, attack, money);
        this.wooMin = wooMin;
        this.greed = greed;
        this.favItemType = favItemType;
        this.rewardItem = rewardItem;
    }
}
