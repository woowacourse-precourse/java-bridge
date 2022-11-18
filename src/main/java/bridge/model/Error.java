package bridge.model;

public enum Error {

    BridgeSizeNotNum("[ERROR] 다리 길이는 숫자를 입력해야 합니다."),
    BridgeSizeNotInBoundary("[ERROR] 다리 길이는 2~20 사이의 숫자를 입력해야 합니다."),
    MoveInputWrong("[ERROR] 이동 선택은 U, D로만 가능합니다."),
    RestartOrMoveWrong("[ERROR] 게임 재시작 및 종료는 R, Q로만 가능합니다.");

    private String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static boolean validateBridgeSizeIsWrong(String inputBridgeSize) {
        if (!inputBridgeSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(BridgeSizeNotNum.getErrorMsg());
        }
        int bridgeSize = Integer.parseInt(inputBridgeSize);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(BridgeSizeNotNum.getErrorMsg());
        }
        return false;
    }

    public static boolean validatePlayerMove(String move) {
        if (!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException(MoveInputWrong.getErrorMsg());
        }
        return false;
    }

    public static boolean validateGameProgress(String progress) {
        if (!(progress.equals("Q") || progress.equals("R"))) {
            throw new IllegalArgumentException(RestartOrMoveWrong.getErrorMsg());
        }
        return false;
    }
}