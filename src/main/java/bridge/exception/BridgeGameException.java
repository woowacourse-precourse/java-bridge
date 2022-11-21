package bridge.exception;

public class BridgeGameException {
    private static final String ONLY_CONTAINS_NUMBER_REGEX = "^[0-9]*$";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private static final String UP_DIRECTION = "U";
    private static final String DOWN_DIRECTION = "D";
    private static final String RESTART_GAME = "R";
    private static final String QUIT_GAME = "Q";
    private static final String ERROR = "[ERROR] ";

    public void validateBridgeSize(String input) {
        validateBridgeInputIsNull(input);
        validateBridgeSizeOnlyContainsNumber(input);
        validateBridgeSizePermittedLength(input);
    }

    public void validateBridgeInputIsNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR + "입력 값이 비었습니다.");
        }
    }

    public void validateDirection(String input) {
        if (!(input.equals(UP_DIRECTION) || input.equals(DOWN_DIRECTION))) {
            throw new IllegalArgumentException(ERROR + "이동할 칸은 U 혹은 D만 가능합니다.");
        }
    }

    public void validateGameStatusCommand(String input) {
        if (!(input.equals(RESTART_GAME) || input.equals(QUIT_GAME))) {
            throw new IllegalArgumentException(ERROR + "게임 재시작은 R, 종료는 Q를 입력해주세요.");
        }
    }

    public void validateBridgeSizeOnlyContainsNumber(String input) {
        if (!input.matches(ONLY_CONTAINS_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR + "다리의 길이는 숫자만 입력이 가능합니다.");
        }
    }

    public void validateBridgeSizePermittedLength(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (!(bridgeSize >= MIN_BRIDGE_SIZE && bridgeSize <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ERROR + "다리의 길이는 3~20 사이의 수입니다.");
        }
    }
}
