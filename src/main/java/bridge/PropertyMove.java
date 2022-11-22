package bridge;

public enum PropertyMove {
    UP("U"),
    DOWN("D"),
    ;
    private final String value;

    PropertyMove(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
