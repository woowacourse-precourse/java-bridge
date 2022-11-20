package bridge.exception;

public class BridgeGameInputException {
    private static final String ONLY_NUMBER = "^[0-9]*$";
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String ERROR_MESSAGE = "[ERROR]";

    public void validateBridgeSize(String size) {
        validateBridgeSizeBlank(size);
        validateBridgeSizeNumber(size);
        validateBridgeSizeRange(size);
    }

    private void validateBridgeSizeNumber(String size) {
        if (!size.matches(ONLY_NUMBER)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 숫자만 입력가능합니다.");
        }
    }

    private void validateBridgeSizeRange(String size) {
        int bridgeSize = Integer.parseInt(size);
        if (bridgeSize < MIN_BRIDGE_LENGTH || bridgeSize > MAX_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이는 3에서 20사이입니다.");
        }
    }

    private void validateBridgeSizeBlank(String size) {
        if (size.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "다리의 길이를 입력해주세요.");
        }
    }

    public void validateMovingChoice(String move) {
        if (!(move.equals(UP) || move.equals(DOWN))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "이동할 칸은 U또는 D만 입력가능합니다.");
        }
    }

    public void validateGameCommand(String gameCommand) {
        if (!(gameCommand.equals(RETRY) || gameCommand.equals(QUIT))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "게임 재시작여부는 R또는 Q만 입력가능합니다.");
        }
    }
}

