package bridge;

public enum Input {
    UP("U", 1),
    DOWN("D", 0),
    RETRY("R"),
    QUIT("Q"),
    ;

    private final String input;
    private final int value;

    Input(String input) {
        this.input = input;
        value = -1;
    }

    Input(String input, int value) {
        this.input = input;
        this.value = value;
    }

    public int toInteger() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.input;
    }
}
