package bridge;

public class InputValidator {

    public void validateInputBridgeSize(String bridgeSize) {
        validateNumber(bridgeSize);
    }

    private void validateInputMove(String command) {
        validateIsOneChar(command);
        validateIsMoveCommand(command.charAt(0));
    }

    private void validateIsMoveCommand(char command) {
        if(isNotMoveCommand(command)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.toString());
        }
    }

    private static boolean isNotMoveCommand(char command) {
        return command != InputType.UP.getValue() && command != InputType.DOWN.getValue();
    }

    private void validateNumber(String number) {
        if(!number.matches(String.valueOf(Regex.NUMBER))) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_OUT_OF_SIZE.toString());
        }
    }

    private void validateIsOneChar(String command) {
        if(!command.matches(Regex.ONE_CHAR.toString())) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.toString());
        }
    }

}
