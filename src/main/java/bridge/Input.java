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
        value = Integer.parseInt(null);
    }

    Input(String input, int value) {
        this.input = input;
        this.value = value;
    }
}
