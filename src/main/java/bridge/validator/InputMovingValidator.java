package bridge.validator;

public class InputMovingValidator {

    public static final String UP = BridgeFormatValidator.UP;
    public static final String DOWN = BridgeFormatValidator.DOWN;

    private static final String MOVING_INPUT_ERROR_MESSAGE = UP + ", " + DOWN + "만 입력할 수 있습니다.";

    public static void validateMovingInput(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
    }
}
