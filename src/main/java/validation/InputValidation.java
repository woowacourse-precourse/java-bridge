package validation;

public class InputValidation {
    public void validateBridgeSize(String input) {
        if (!input.matches("^[1-9]+[0-9]*$")) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.INVALID_BRIDGE_SIZE));
        }
    }
}
