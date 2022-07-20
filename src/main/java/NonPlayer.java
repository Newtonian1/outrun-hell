public class NonPlayer extends Character{
    private double wooMin;
    private String favItemType;
    private String rewardItem = "none";

    private String[] catchPhrases;

    //CONSTRUCTORS
    public NonPlayer(String name, int maxHealth, int attack, int money, double wooMin, String favItemType, String[] catchPhrases, String rewardItem) {
        super(name, maxHealth, attack, money);
        this.wooMin = wooMin;
        this.favItemType = favItemType;
        this.catchPhrases = catchPhrases;
        this.rewardItem = rewardItem;
    }

    public NonPlayer(){};

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

    //NPC GENERATOR
    public static NonPlayer genNonPlayer(String npcName) {
        NonPlayer npc = new NonPlayer();
        switch (npcName) {
            case "Joe":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.attack = 2;
                npc.money = 35;
                npc.wooMin = 0.7;
                npc.favItemType = "Tech Item";
                npc.rewardItem = "rtx 3090";
                npc.catchPhrases = new String[]{"nice", "cool"};
                break;
            case "Beth":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.attack = 2;
                npc.money = 35;
                npc.wooMin = 0.7;
                npc.favItemType = "Valuable Item";
                npc.rewardItem = "rtx 3090";
                npc.catchPhrases = new String[]{"nice", "cool"};
                break;
        }
        return npc;
    }
}
