package bridge;

public enum Choose {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    EXIT("Q"),
    SUCCESS("O"),
    FAILURE("X");

    private final String value;

    private Choose(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}