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
            case "Caligula":
                npc.name = npcName;
                npc.maxHealth = 14;
                npc.health = npc.getMaxHealth();
                npc.attack = 2;
                npc.money = 70;
                npc.wooMin = 0.55;
                npc.favItemType = "Artifact Item";
                npc.rewardItem = "stone tablet";
                npc.introText = "How should it be that I, Caligula, the third emperor of Rome, have ended up amongst these heathens... Oh the times oh the immorals!";
                npc.catchPhrases = new String[]{"What do you mean Latin is DEAD?", "Have you ever been assassinated?", "If anyone belongs here, it's my nephew", "In a way I was the first cosplayer"};
                break;
            case "Adolf":
                npc.name = npcName;
                npc.maxHealth = 9;
                npc.health = npc.getMaxHealth();
                npc.attack = 3;
                npc.money = 30;
                npc.wooMin = 0.90;
                npc.favItemType = "none";
                npc.rewardItem = "none";
                npc.introText = "Adolf: You shouldn't really be surprised to see me here";
                npc.catchPhrases = new String[]{"I wish I got into art school...", "Why don't I have any friends?", "Yesterday I overheard Stalin call me a bad person", "Not even the other evil people like me..."};
                break;
            case "Vlad":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 3;
                npc.money = 60;
                npc.wooMin = 0.80;
                npc.favItemType = "Valuable Item";
                npc.rewardItem = "health potion";
                npc.introText = "They call me Vlad the impaler. I used to run my own acupuncture shop here before it got bought out by the Walmart-Costco-Target conglomerate.";
                npc.catchPhrases = new String[]{"You got any spare spikes on you?", "This place is a lot warmer than what I'm used to", "Did you know I have a killer moustache?", "Impaling is an art! You wouldn't understand..."};
                break;
            case "Genghis Khan":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 4;
                npc.money = 90;
                npc.wooMin = 0.70;
                npc.favItemType = "Artifact Item";
                npc.rewardItem = "grenade";
                npc.introText = "Genghis Khan: Yeah, you may or may not be one of my descendants. It's really a toss up!";
                npc.catchPhrases = new String[]{"Have you heard the Miike Snow song about me?", "There isn't enough land to conquer here", "You ever drank horse blood?", "I bet I could take over Hell too"};
                break;
            case "Queen Mary":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 3;
                npc.money = 70;
                npc.wooMin = 0.90;
                npc.favItemType = "Valuable Item";
                npc.rewardItem = "pearl necklace";
                npc.introText = "Bow before me! I am Queen Mary the first, former queen of England and current CEO of the Heinz-Pepsi-Nestle corporation";
                npc.catchPhrases = new String[]{"Wait, they really named a drink after me?", "Bloody hell!", "If you need a job, I'm happy to look at your resume", "No, not really a fan of tomatoes"};
                break;
            case "Azula":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 2;
                npc.money = 30;
                npc.wooMin = 0.80;
                npc.favItemType = "Valuable Item";
                npc.rewardItem = "hell rocket";
                npc.introText = "Azula: Grrrrrrrrr you are SO LUCKY I can't firebend down here.";
                npc.catchPhrases = new String[]{"Don't flatter yourself. You were never even a player.", "You miscalculated. You should have feared me more.", "My own mother thought I was a monster. She was right of course.", "Trust is for fools, fear is the only reliable way"};
                break;
            case "Thanos":
                npc.name = npcName;
                npc.maxHealth = 15;
                npc.health = npc.getMaxHealth();
                npc.attack = 3;
                npc.money = 90;
                npc.wooMin = 0.90;
                npc.favItemType = "Tech Item";
                npc.rewardItem = "health potion";
                npc.introText = "Thanos: I will shred this universe down to its last atom. And then... create a new one... a grateful universe.";
                npc.catchPhrases = new String[]{"You should have gone for the head", "This... does put a smile on my face", "I am inevitable", "I don't even know who you are"};
                break;
            case "Joker":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 2;
                npc.money = 30;
                npc.wooMin = 0.95;
                npc.favItemType = "none";
                npc.rewardItem = "first aid kit";
                npc.introText = "Joker: Wanna know how I got these scars? HaHAhaHahAHahAHahAhaHaHaHAha";
                npc.catchPhrases = new String[]{"Why so serious?", "You get what you ****ing deserve!", "Nobody's civil anymore", "All it takes is one bad day to reduce the sanest man alive to lunacy"};
                break;
            case "name":
                npc.name = npcName;
                npc.maxHealth = 10;
                npc.health = npc.getMaxHealth();
                npc.attack = 2;
                npc.money = 40;
                npc.wooMin = 0.80;
                npc.favItemType = "Tech Item";
                npc.rewardItem = "health potion";
                npc.introText = "...";
                npc.catchPhrases = new String[]{"...", "...", "...", "..."};
                break;
            default:
                break;
        }
        return npc;
    }
}
