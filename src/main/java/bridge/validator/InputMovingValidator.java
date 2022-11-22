package bridge.validator;

public class InputMovingValidator {

    public static final String UP = BridgeFormatValidator.UP;
    public static final String DOWN = BridgeFormatValidator.DOWN;

    private static final String MOVING_INPUT_ERROR_MESSAGE = "[ERROR] 이동할 칸 입력 시 " + UP + ", " + DOWN + "만 입력 가능합니다.";

    public static void validateMovingInput(String input) {
        if (!input.equals(UP) && !input.equals(DOWN)) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
    }
}
