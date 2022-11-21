package bridge.model;

import static bridge.model.BridgeMaker.DOWN_BRIDGE;
import static bridge.model.BridgeMaker.UP_BRIDGE;

public class InputValidator {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String IS_NUMBER = "[0-9]*";
    public static final String RESTART_GAME = "R";
    public static final String QUIT_GAME = "Q";
    public static final String ERROR_INPUT_ABOUT_BRIDGE_SIZE = "[ERROR] 3-20사이의 숫자가 아닙니다.";
    public static final String ERROR_INPUT_ABOUT_MOVING = "[ERROR] Moving 문자를 잘못 입력하셨습니다.";
    public static final String ERROR_INPUT_ABOUT_RETRY = "[ERROR] Retry 문자를 잘못 입력하셨습니다.";

    private InputValidator() {
    }

    public static void isValidSize(String inputSize) {
        isNullOrBlank(inputSize, ERROR_INPUT_ABOUT_BRIDGE_SIZE);
        if (!inputSize.matches(IS_NUMBER)) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_BRIDGE_SIZE);
        }
        int size = Integer.parseInt(inputSize);
        if (size > BRIDGE_MAX_SIZE || size < BRIDGE_MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_BRIDGE_SIZE);
        }
    }

    public static void isValidMoving(String moving) {
        isNullOrBlank(moving, ERROR_INPUT_ABOUT_MOVING);
        if (!moving.equals(UP_BRIDGE) && !moving.equals(DOWN_BRIDGE)) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_MOVING);
        }
    }

    public static void isValidRetry(String restart) {
        isNullOrBlank(restart, ERROR_INPUT_ABOUT_RETRY);
        if (!restart.equals(RESTART_GAME) && !restart.equals(QUIT_GAME)) {
            throw new IllegalArgumentException(ERROR_INPUT_ABOUT_RETRY);
        }
    }

    private static void isNullOrBlank(String inputSize,String message) {
        if ( inputSize == null || inputSize.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
