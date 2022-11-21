package bridge.view;

public enum UserMove {
    UP("U"),
    DOWN("D");

    UserMove(String input) {
        this.input = input;
    }

    private final String input;

    public String getInput() {
        return input;
    }

    public static UserMove getUserMove(String input) {
        if (input.equals(UP.input)) {
            return UP;
        }
        return DOWN;
    }
}
