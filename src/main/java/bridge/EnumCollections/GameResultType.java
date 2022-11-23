package bridge.EnumCollections;

public enum GameResultType {
    START("[ "),
    MID(" | "),
    END(" ]");

    private String format;
    GameResultType(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
