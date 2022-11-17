package bridge;

import static bridge.BridgeMaker.DOWN_BRIDGE;
import static bridge.BridgeMaker.UP_BRIDGE;

public class InputValidator {

    public static final int BRIDGE_MIN_SIZE = 3;
    public static final int BRIDGE_MAX_SIZE = 20;
    public static final String IS_NUMBER = "[0-9]*";

    public static final String RESTART_GAME = "R";
    public static final String QUIT_GAME = "Q";

    private InputValidator() {
    }

    public static boolean isValidSize(String inputSize) {
        if (inputSize == null || inputSize.isBlank()) {
            return false;
        }
        if (!inputSize.matches(IS_NUMBER)) {
            return false;
        }
        int size = Integer.parseInt(inputSize);
        return size <= BRIDGE_MAX_SIZE && size >= BRIDGE_MIN_SIZE;
    }

    public static void throwError(String errorMessage) {
        try {
            throw new IllegalArgumentException(errorMessage);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidMoving(String moving) {
        if (moving == null) {
            return false;
        }
        return moving.equals(UP_BRIDGE) || moving.equals(DOWN_BRIDGE);
    }

    public static boolean isValidRestart(String restart) {
        if (restart == null) {
            return false;
        }
        return restart.equals(RESTART_GAME) || restart.equals(QUIT_GAME);
    }
}
