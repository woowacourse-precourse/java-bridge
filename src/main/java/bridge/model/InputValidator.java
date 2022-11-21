package bridge.model;

import static bridge.model.BridgeMaker.DOWN_BRIDGE;
import static bridge.model.BridgeMaker.UP_BRIDGE;

public class InputValidator {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String IS_NUMBER = "[0-9]*";
    public static final String RESTART_GAME = "R";
    public static final String QUIT_GAME = "Q";

    private InputValidator() {
    }

    public static boolean isValidSize(String inputSize) {
        if (isNullOrBlank(inputSize) || !inputSize.matches(IS_NUMBER)) {
            return false;
        }
        int size = Integer.parseInt(inputSize);
        return size <= BRIDGE_MAX_SIZE && size >= BRIDGE_MIN_SIZE;
    }

    private static boolean isNullOrBlank(String inputSize) {
        return inputSize == null || inputSize.isBlank();
    }

    public static boolean isValidMoving(String moving) {
        if (isNullOrBlank(moving)) {
            return false;
        }
        return moving.equals(UP_BRIDGE) || moving.equals(DOWN_BRIDGE);
    }

    public static boolean isValidRetry(String restart) {
        if (isNullOrBlank(restart)) {
            return false;
        }
        return restart.equals(RESTART_GAME) || restart.equals(QUIT_GAME);
    }
}
