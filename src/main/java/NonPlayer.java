public class NonPlayer extends Character{
    private double wooMin;
    private double greed;
    private String favItemType;
    private String rewardItem = "none";

    private String[] catchPhrases;

    //CONSTRUCTORS
    public NonPlayer(String name, int maxHealth, int attack, int money, double wooMin, double greed, String favItemType, String[] catchPhrases) {
        super(name, maxHealth, attack, money);
        this.wooMin = wooMin;
        this.greed = greed;
        this.favItemType = favItemType;
        this.catchPhrases = catchPhrases;
    }

    public NonPlayer(String name, int maxHealth, int attack, int money, double wooMin, double greed, String favItemType, String[] catchPhrases, String rewardItem) {
        super(name, maxHealth, attack, money);
        this.wooMin = wooMin;
        this.greed = greed;
        this.favItemType = favItemType;
        this.catchPhrases = catchPhrases;
        this.rewardItem = rewardItem;
    }

    //GETTERS
    public double getWooMin() {
        return wooMin;
    }

    public double getGreed() {
        return greed;
    }

    public String getFavItemType() {
        return favItemType;
    }

    public String getRewardItem() {
        return rewardItem;
    }
}
