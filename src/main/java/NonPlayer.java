public class NonPlayer extends Character{
    private double wooMin;
    private String favItemType;
    private String rewardItem = "none";

    private String introText;

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

    public String getIntroText() {
        return introText;
    }

    public String getCatchPhrase() {
        int phraseNumber = (int)(Math.random() * 4);
        return catchPhrases[phraseNumber];
    }

    //NPC GENERATOR
    public static NonPlayer genNonPlayer(String npcName) {
        NonPlayer npc = new NonPlayer();
        switch (npcName) {
            case "Tobey Maguire":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 3;
                npc.money = 50;
                npc.wooMin = 0.75;
                npc.favItemType = "none";
                npc.rewardItem = "none";
                npc.introText = "The name's Maguire... Tobey Maguire. I know what you're probably thinking, what is Tobey doing here... have you seen Spiderman 3?";
                npc.catchPhrases = new String[]{"Ow, my back!", "I'm gonna put some dirt in your eye", "You'll get your rent when you fix this damn door!", "You want forgiveness? Get religion."};
                break;
            case "Beth":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.attack = 2;
                npc.money = 35;
                npc.wooMin = 0.7;
                npc.favItemType = "Valuable Item";
                npc.rewardItem = "rtx 3090";
                npc.introText = "";
                npc.catchPhrases = new String[]{"nice", "cool"};
                break;
        }
        return npc;
    }
}
