public class NonPlayer extends Character{
    private double wooMin;
    private String favItemType;
    private String rewardItem = "none";

    private String[] catchPhrases;

    //CONSTRUCTORS
    public NonPlayer(String name, int maxHealth, int attack, int money, double wooMin, String favItemType, String[] catchPhrases) {
        super(name, maxHealth, attack, money);
        this.wooMin = wooMin;
        this.favItemType = favItemType;
        this.catchPhrases = catchPhrases;
    }

    public NonPlayer(String name, int maxHealth, int attack, int money, double wooMin, String favItemType, String[] catchPhrases, String rewardItem) {
        super(name, maxHealth, attack, money);
        this.wooMin = wooMin;
        this.favItemType = favItemType;
        this.catchPhrases = catchPhrases;
        this.rewardItem = rewardItem;
    }

    //GETTERS
    public double getWooMin() {
        return wooMin;
    }

    public String getFavItemType() {
        return favItemType;
    }

    public String getRewardItem() {
        return rewardItem;
    }
}
