package bridge.enums;

public enum Regex {
    BRIDGE_SIZE_REGEX("^[0-9]+$"),
    MOVING_DIRECTION_REGEX("^[U|D]{1}$"),
    GAME_COMMAND_REGEX("^[R|Q]{1}$")
    ;
    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
