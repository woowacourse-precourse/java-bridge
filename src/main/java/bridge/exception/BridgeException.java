package bridge.exception;

public class BridgeException {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String ERROR = "[ERROR] ";

    public void isValidBridge(String input) {
        isNull(input);
        isNumber(input);
        isInRange(input);
    }

    public void isNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR + "입력값이 비었습니다.");
        }
    }

    public void isNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR + "다리의 길이는 숫자만 입력이 가능합니다.");
        }
    }

    public void isInRange(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (!(bridgeSize >= MIN_SIZE && bridgeSize <= MAX_SIZE)) {
            throw new IllegalArgumentException(ERROR + "다리의 길이는 3 ~ 20 사이의 수입니다.");
        }
    }

    public void isMovement(String input) {
        if (!(input.equals(UP) || input.equals(DOWN))) {
            throw new IllegalArgumentException(ERROR + "이동할 칸은 U 혹은 D만 가능합니다.");
        }
    }

    public void isDecision(String input) {
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            throw new IllegalArgumentException(ERROR + "게임 재시작은 R, 종료는 Q를 입력해주세요.");
        }
    }
}
