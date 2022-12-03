package bridge;

public enum CommandType {
    DOWN("D"),
    UP("U"),
    RETRY("R"),
    QUIT("Q");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
