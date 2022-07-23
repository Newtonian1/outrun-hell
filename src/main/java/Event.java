abstract public class Event {
    protected String stageSettingText;
    protected String conclusionText;

    //CONSTRUCTORS
    public Event(String stageSettingText, String conclusionText) {
        this.stageSettingText = stageSettingText;
        this.conclusionText = conclusionText;
    }

    public Event() {}
}
