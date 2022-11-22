package bridge;

public class InputException {
    private final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final int BRIDGE_MIN_SIZE = 3;
    private final int BRIDGE_MAX_SIZE = 20;
    private final String MOVE_INPUT_ERROR = "[ERROR] 위: U, 아래: D 를 입력하세요.";
    private final String RETRY_INPUT_ERROR = "[ERROR] 재시도: R, 종료: Q 를 입력하세요.";

    public int validBridgeSize(String playerInput) {
        if (!playerInput.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        int bridgeSize = Integer.parseInt(playerInput);
        if (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        return bridgeSize;
    }

    public void validMove(String playerInput) {
        if (!(playerInput.equals("U") || playerInput.equals("D"))) {
            throw new IllegalArgumentException(MOVE_INPUT_ERROR);
        }
    }

    public void validRetryValue(String playerInput) {
        if (!(playerInput.equals("R") || playerInput.equals("Q"))) {
            throw new IllegalArgumentException(RETRY_INPUT_ERROR);
        }
    }
}
