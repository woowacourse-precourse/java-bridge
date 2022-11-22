package bridge.validation;

import static bridge.validation.ErrorMessage.*;

public class ReadGameCommandValidation {
    private static final String RESTART_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    public void validateInputFormat(String gameCommand) {
        if ((! gameCommand.equals(RESTART_COMMAND)) && (! gameCommand.equals(QUIT_COMMAND))) {
            throw new IllegalArgumentException(INPUT_COMMAND_IN_R_OR_Q.getMessage());
        }
    }
}
