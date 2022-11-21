package bridge;


import bridge.constant.ErrorMessage;

public class InputValidator {

    private static final String BRIDGE_SIZE_LIMIT = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";
    private static final String DIRECTIONS = "^[U|D]{1}$";
    private static final String RETRY_OR_QUIT = "^[R|Q]{1}$";

    private final String input;

    public InputValidator(String input) {
        this.input = input;
    }

    public void isInRangeSize() {
        if (!input.matches(BRIDGE_SIZE_LIMIT)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BRIDGE_SIZE_ERROR.toString());
        }
    }

    public void isUpOrDown() {
        if (!input.matches(DIRECTIONS)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DIRECTION_ERROR.toString());
        }
    }

    public void isRetryOrQuit() {
        if (!input.matches(RETRY_OR_QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_RETRY_OR_QUIT_ERROR.toString());
        }
    }
}
