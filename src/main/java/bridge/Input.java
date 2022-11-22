package bridge;

public enum Input {
    UP("U", 1),
    DOWN("D", 0),
    RETRY("R"),
    QUIT("Q"),
    MIN_VALUE(3),
    MAX_VALUE(20);

    private final String input;
    private final int value;

    Input(String input) {
        this.input = input;
        this.value = -1;
    }

    Input(int value) {
        this.input = "";
        this.value = value;
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
