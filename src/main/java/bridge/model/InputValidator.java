package bridge.model;

import static bridge.BridgeMaker.DOWN_BRIDGE;
import static bridge.BridgeMaker.UP_BRIDGE;

public class InputValidator {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String IS_NUMBER = "[0-9]*";
    public static final String RESTART_GAME = "R";
    public static final String QUIT_GAME = "Q";
    public static final String ERROR_INPUT_ABOUT_BRIDGE_SIZE = "[ERROR] 3-20사이의 숫자가 아닙니다.";
    public static final String ERROR_INPUT_ABOUT_MOVING = "[ERROR] Moving 문자를 잘못 입력하셨습니다.";
    public static final String ERROR_INPUT_ABOUT_RETRY = "[ERROR] Retry 문자를 잘못 입력하셨습니다.";

    public InputValidator() {
    }

    public void isValidSize(String inputSize) throws IllegalArgumentException{
        isNullOrBlank(inputSize, ERROR_INPUT_ABOUT_BRIDGE_SIZE);
        int size = isNumber(inputSize);
        isRightSize(size);
    }

    private Integer isNumber(String inputSize) {
        if (!inputSize.matches(IS_NUMBER)) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_BRIDGE_SIZE);
        }
        return Integer.parseInt(inputSize);
    }

    private void isRightSize(int size) {
        if (size > BRIDGE_MAX_SIZE || size < BRIDGE_MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_BRIDGE_SIZE);
        }
    }

    public void isValidMoving(String moving) {
        isNullOrBlank(moving, ERROR_INPUT_ABOUT_MOVING);
        if (!moving.equals(UP_BRIDGE) && !moving.equals(DOWN_BRIDGE)) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_MOVING);
        }
    }

    public void isValidRetry(String restart) {
        isNullOrBlank(restart, ERROR_INPUT_ABOUT_RETRY);
        if (!restart.equals(RESTART_GAME) && !restart.equals(QUIT_GAME)) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_RETRY);
        }
    }

    private void isNullOrBlank(String input, String message) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
