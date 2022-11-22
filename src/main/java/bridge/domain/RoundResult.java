package bridge.domain;

import java.util.Arrays;

public enum RoundResult {

    SELECTED_UPPER_CASE_IF_CORRECT(Constants.UP_COMMAND, Constants.UP_COMMAND),
    SELECTED_UPPER_CASE_IF_WRONG(Constants.UP_COMMAND, Constants.DOWN_COMMAND),
    SELECTED_LOWER_CASE_IF_CORRECT(Constants.DOWN_COMMAND, Constants.DOWN_COMMAND),
    SELECTED_LOWER_CASE_IF_WRONG(Constants.DOWN_COMMAND, Constants.UP_COMMAND);

    private final String command;
    private final String answer;

    RoundResult(String command, String answer) {
        this.command = command;
        this.answer = answer;
    }

    public static RoundResult valueOf(String command, String answer) {
        return Arrays.stream(values())
                .filter(roundResult -> command.equals(roundResult.command) && answer.equals(roundResult.answer))
                .findFirst()
                .get();
    }
}
