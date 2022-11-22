package bridge;

public class InputValidator {

    public void validateInputBridgeSize(String bridgeSize) {
        validateNumber(bridgeSize);
        validateSize(Integer.parseInt(bridgeSize));
    }

    public void validateInputMove(String command) {
        validateIsOneChar(command);
        validateIsMoveCommand(command.charAt(0));
    }

    public void validateInputRetry(String command) {
        validateIsOneChar(command);
        validateIsRetryCommand(command.charAt(0));
    }

    private void validateSize(int size) {
        if (isOutOfSize(size)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_OUT_OF_SIZE.toString());
        }
    }

    private boolean isOutOfSize(int size) {
        return size < GameSetting.MIN_BRIDGE_SIZE.getValue() || size > GameSetting.MAX_BRIDGE_SIZE.getValue();
    }

    private void validateIsRetryCommand(char command) {
        if (isNotRetryCommand(command)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.toString());
        }
    }

    private boolean isNotRetryCommand(char command) {
        return command != Command.RETRY.getValue() && command != Command.QUIT.getValue();
    }

    private void validateIsMoveCommand(char command) {
        if (isNotMoveCommand(command)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.toString());
        }
    }

    private static boolean isNotMoveCommand(char command) {
        return command != Command.UP.getValue() && command != Command.DOWN.getValue();
    }

    private void validateNumber(String number) {
        if (!number.matches(String.valueOf(Regex.NUMBER))) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_OUT_OF_SIZE.toString());
        }
    }

    private void validateIsOneChar(String command) {
        if (!command.matches(Regex.ONE_CHAR.toString())) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT.toString());
        }
    }

}
