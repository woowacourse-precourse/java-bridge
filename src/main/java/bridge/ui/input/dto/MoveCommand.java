package bridge.ui.input.dto;

import bridge.domain.bridge.BridgeDirection;
import bridge.ui.input.InputErrorText;
import java.util.regex.Pattern;

public class MoveCommand {
    private final String moveCommand;

    private MoveCommand(String moveCommand) {
        validate(moveCommand);
        this.moveCommand = moveCommand;
    }

    public static MoveCommand from(String userInput) {
        return new MoveCommand(userInput);
    }

    private void validate(String moveCommand) {
        String moveCommandRegex = "^([UD])$";

        if (!Pattern.matches(moveCommandRegex, moveCommand)) {
            throw new IllegalArgumentException(InputErrorText.ERROR_MOVE_COMMAND.errorText());
        }
    }

    public BridgeDirection toBridgeDirection() {
        return BridgeDirection.fromSignature(this.moveCommand);
    }
}
