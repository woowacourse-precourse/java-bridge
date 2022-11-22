package bridge;

import static bridge.BridgeGame.*;

public enum Exception {

    BridgeSizeNotNum("[ERROR] 다리 길이는 숫자를 입력해야 합니다."),
    BridgeSizeNotInBoundary("[ERROR] 다리 길이는 2~20 사이의 숫자를 입력해야 합니다."),
    MoveInputWrong("[ERROR] 이동 선택은 U, D로만 가능합니다."),
    RestartOrMoveWrong("[ERROR] 게임 재시작 및 종료는 R, Q로만 가능합니다.");

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String EXIT_KEY = "Q";

    private final String errorMessage;

    Exception(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static boolean validateBridgeSize(String tempBridgeSize) {
        if (!tempBridgeSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(BridgeSizeNotNum.getErrorMessage());
        }
        int bridgeSize = Integer.parseInt(tempBridgeSize);
        if (bridgeSize < MIN_SIZE || bridgeSize > MAX_SIZE) {
            throw new IllegalArgumentException(BridgeSizeNotNum.getErrorMessage());
        }
        return false;
    }

    public static boolean validatePlayerMove(String move) {
        if (!(move.equals(UPPER_SELECT) || move.equals(LOWER_SELECT))) {
            throw new IllegalArgumentException(MoveInputWrong.getErrorMessage());
        }
        return false;
    }

    public static boolean validateGameProgress(String progress) {
        if (!(progress.equals(EXIT_KEY) || progress.equals(REPLAY_KEY))) {
            throw new IllegalArgumentException(RestartOrMoveWrong.getErrorMessage());
        }
        return false;
    }

}