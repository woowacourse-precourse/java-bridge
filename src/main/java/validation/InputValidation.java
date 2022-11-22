package validation;

import java.util.List;

public class InputValidation {
    public void validateBridgeSize(String input) {
        if (!input.matches("^[1-9]+[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public void validateMoving(String input) {

        List<String> orders = List.of("U", "D");

        if (!orders.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING_ORDER.getMessage());
        }
    }

    public void validateGameCommand(String input) {

        List<String> commands = List.of("R", "Q");

        if (!commands.contains(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND.getMessage());
        }
    }

}
