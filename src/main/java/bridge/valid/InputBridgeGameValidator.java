package bridge.valid;

public class InputBridgeGameValidator {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String IS_DIGIT_ERROR = "[ERROR] 숫자를 입력하여야 합니다.";
    private static final String BRIDGE_SIZE_RANGE_ERROR = "[ERROR] 3 이상 20 이하의 숫자를 입력하여야 합니다.";
    private static final String MOVE_COMMAND_ERROR = "[ERROR] U와 D 중 하나의 문자를 입력하여야 합니다.";
    private static final String GAME_COMMAND_ERROR = "[ERROR] R과 Q 중 하나의 문자를 입력하여야 합니다.";

    public void isDigit(String bridgeSize) {
        if (bridgeSize.equals("")) {
            throw new IllegalArgumentException(IS_DIGIT_ERROR);
        }

        for (int i = 0; i < bridgeSize.length(); i++) {
            if (!Character.isDigit(bridgeSize.charAt(i))) {
                throw new IllegalArgumentException(IS_DIGIT_ERROR);
            }
        }
    }

    public void checkBridgeSizeRange(String bridgeSize) {
        int getBridgeSize = Integer.parseInt(bridgeSize);

        if(!(getBridgeSize >= MIN_BRIDGE_SIZE && getBridgeSize <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR);
        }
    }

    public void validateBridgeSize(String bridgeSize) {
        isDigit(bridgeSize);
        checkBridgeSizeRange(bridgeSize);
    }

    public void isMoveCommand(String moveCommand) {
        if (!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            throw new IllegalArgumentException(MOVE_COMMAND_ERROR);
        }
    }

    public void isGameCommand(String gameCommand) {
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }
    }
}
