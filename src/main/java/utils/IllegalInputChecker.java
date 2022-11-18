package utils;

public class IllegalInputChecker {
    private static final String BRIDGE_SIZE = "^\\d{1,2}$";
    private static final String MOVE_INPUT = "^\\[UD]$";
    private static final String GAME_OPTION = "^\\[RQ]$";

    public int checkBridgeSizeInput(String bridgeSize) {
        isBridgeSizeNumeric(bridgeSize);
        return isNumOfBridgeSizeValid(bridgeSize);
    }

    public String checkMoveInput(String moveInput) {
        if (!moveInput.matches(MOVE_INPUT)) {
            throw new IllegalArgumentException(ExceptionMessage.MOVE_INPUT_INVALID);
        }
        return moveInput;
    }

    public String checkRestartOrQuit(String option) {
        if (!option.matches(GAME_OPTION)) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_OPTION_INVALID);
        }
        return option;
    }

    public void isBridgeSizeNumeric (String bridgeSize) {
        if (!bridgeSize.matches(BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE_NOT_NUMERIC);
        }
    }

    public int isNumOfBridgeSizeValid (String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE_NUM_INVALID);
        }
        return Integer.parseInt(bridgeSize);
    }

}
