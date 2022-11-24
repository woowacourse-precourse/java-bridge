package bridge;

import java.util.Arrays;

public enum GameCommend {
    RESTART("R"),
    EXIT("Q");

    private final String input;

    GameCommend(final String input) {
        this.input = input;
    }

    public static boolean contains(final String input) {
        return Arrays.stream(values())
            .anyMatch(commend -> commend.matchInput(input));
    }

    private boolean matchInput(final String input) {
        return this.input.equals(input);
    }

    public static GameCommend of(final String input) {
        return Arrays.stream(values())
            .filter(commend -> commend.matchInput(input))
            .findAny()
            .orElse(EXIT);
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
