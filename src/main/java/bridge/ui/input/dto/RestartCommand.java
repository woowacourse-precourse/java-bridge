package bridge.ui.input.dto;

import bridge.ui.input.InputErrorText;
import java.util.regex.Pattern;

public class RestartCommand {
    private final String restartCommand;

    private RestartCommand(String restartCommand) {
        validate(restartCommand);
        this.restartCommand = restartCommand;
    }

    public static RestartCommand from(String userInput) {
        return new RestartCommand(userInput);
    }

    private void validate(String restartCommand) {
        String moveCommandRegex = "^([RQ])$";

        if (!Pattern.matches(moveCommandRegex, restartCommand)) {
            throw new IllegalArgumentException(InputErrorText.ERROR_RESTART_COMMAND.errorText());
        }
    }

    public boolean isRestartCommand() {
        if (restartCommand.equals("R")) {
            return true;
        }

        return false;
    }
}
