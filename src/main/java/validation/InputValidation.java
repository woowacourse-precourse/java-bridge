package validation;

import java.util.List;

public class InputValidation {
    public void validateBridgeSize(String input) {
        if (!input.matches("^[1-9]+[0-9]*$")) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.INVALID_BRIDGE_SIZE));
        }
    }

    public void validateMoving(String input) {

        List<String> orders = List.of("U", "D");

        if (!orders.contains(input)) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.INVALID_MOVING_ORDER));
        }
    }

}
