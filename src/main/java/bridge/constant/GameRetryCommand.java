package bridge.constant;

import java.util.Arrays;

public enum GameRetryCommand {

    RETRY("R"),
    QUIT("Q");

    private final String firstLetter;

    GameRetryCommand(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public static void validateInputCommand(String input) {
        boolean match = Arrays.stream(GameRetryCommand.values())
                .anyMatch(command -> command.equals(input));
        if (!match) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_FORMAT_IS_INCORRECT.getMessage());
        }
    }
}
