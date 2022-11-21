package bridge.config;

public enum UserInput {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String value;

    UserInput(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isUpDown(String userInput) {
        return userInput.equals(UserInput.UP.value)
                || userInput.equals(UserInput.DOWN.value);
    }

    public static boolean isRetryQuit(String userInput) {
        return userInput.equals(UserInput.RETRY.value)
                || userInput.equals(UserInput.QUIT.value);
    }
}
