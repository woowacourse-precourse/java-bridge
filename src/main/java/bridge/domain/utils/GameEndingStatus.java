package bridge.domain.utils;

public enum GameEndingStatus {

    CLEAR(""),
    RETRY("R"),
    QUIT("Q");

    private final String value;

    GameEndingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
