package bridge;


import bridge.constant.ErrorMessage;

public class InputManagement {

    private static final String NUMBER = "^[0-9]+$";
    private static final String DIRECTIONS = "^[U|D]{1}$";
    private static final String RETRY_OR_QUIT = "^[R|Q]{1}$";
    private static final String RETRY = "R";

    private final String input;

    public InputManagement(String input) {
        this.input = input;
    }

    public void isNumber() {
        if (!input.matches(NUMBER)) {
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

    public boolean isRetry() {
        return input.equals(RETRY);
    }
}
