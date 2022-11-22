package bridge.config;

import java.util.List;

public enum UserInput {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String value;
    public static final List<String> intToUpDown = List.of(UserInput.DOWN.getValue(), UserInput.UP.getValue());

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
