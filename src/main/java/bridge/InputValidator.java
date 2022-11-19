package bridge;

public class InputValidator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String NUMBER_TYPE_REGEX = "[0-9]+";

    public void validateNumberType(String inputNumber) {
        if (!inputNumber.matches(NUMBER_TYPE_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateZeroPrefix(String inputNumber) {
        if (inputNumber.startsWith("0")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBridgeSize(int inputNumber) {
        if (inputNumber < MIN_BRIDGE_SIZE || inputNumber > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void validateMovingPosition(String movingPosition) {
        if (!BridgePosition.UP.isEqualToBridgePosition(movingPosition) &&
                !BridgePosition.DOWN.isEqualToBridgePosition(movingPosition)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!GameCommand.RETRY.isEqual(gameCommand) &&
                !GameCommand.QUIT.isEqual(gameCommand)) {
            throw new IllegalArgumentException();
        }
    }
}
