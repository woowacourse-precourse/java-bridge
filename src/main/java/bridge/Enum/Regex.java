package bridge.Enum;

public enum Regex {
    BRIDGE_SIZE_ONLY_NUMBER("\\d+"),
    MOVING_DIRECTION_ONLY_UD("[UD]"),
    GAME_COMMAND_ONLY_RQ("[QR]"),
    ;
    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
