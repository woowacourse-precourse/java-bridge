package bridge.enums;

public enum InputConstants {
    UP_MOVE("U"),
    DOWN_MOVE("D"),
    RETRY_GAME("R"),
    QUIT_GAME("Q"),
    ;

    private String value;

    InputConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
