package bridge.view;

public class InputValidation {
    private static final String BRIDGE_SIZE_INPUT_ERROR = "[ERROR] 2자리의 숫자로 입력해주세요.";
    private static final String WRONG_MOVING_MARK_INPUT_ERROR = "[ERROR] U 혹은 D를 입력해주세요.";
    private static final String WRONG_RETRY_INPUT_ERROR = "[ERROR] R 혹은 Q를 입력해주세요.";

    public void validateBridgeSizeInput(String bridgeSizeInput) {
        String match = "^\\d{1,2}$";
        if (!bridgeSizeInput.matches(match)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INPUT_ERROR);
        }
    }

    public void validateMovingInput(String selectUpOrDownInput) {
        String match = "^[U|D]$";
        if (!selectUpOrDownInput.matches(match)) {
            throw new IllegalArgumentException(WRONG_MOVING_MARK_INPUT_ERROR);
        }
    }

    public void validateGameCommandInput(String gameCommandInput) {
        String match = "^[R|Q]$";
        if (!gameCommandInput.matches(match)) {
            throw new IllegalArgumentException(WRONG_RETRY_INPUT_ERROR);
        }
    }
}
