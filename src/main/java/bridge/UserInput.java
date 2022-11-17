package bridge;

public enum UserInput {
    UP("U"),
    DOWN("D"),
    RESTART("R"),
    QUIT("Q"),
    SUCCESS("O"),
    FAILURE("X");

    private final String value;
    private UserInput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
