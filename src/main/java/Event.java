abstract public class Event {
    protected String stageSettingText;
    protected String conclusionText;

    public Event(String stageSettingText, String conclusionText) {
        this.stageSettingText = stageSettingText;
        this.conclusionText = conclusionText;
    }
}
