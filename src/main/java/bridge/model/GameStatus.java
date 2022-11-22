package bridge.model;

public enum GameStatus {
    SUCCESS("성공", true),
    FAILURE("실패", false);
    private final String StringKey;
    private final boolean booleanKey;

    private GameStatus(String StringKey, boolean booleanKey) {
        this.StringKey = StringKey;
        this.booleanKey = booleanKey;
    }

    public String getStringKey() {
        return StringKey;
    }

    public boolean getBooleanKey() {
        return booleanKey;
    }

}
