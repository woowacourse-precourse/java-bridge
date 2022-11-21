package bridge.domain.game;

public enum Retry {
    RETRY("R"),
    QUIT("Q");

    String value;

    Retry(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
