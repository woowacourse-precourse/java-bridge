package bridge.vo;

public enum ErrorMessage {
    BRIDGE_SIZE_NOT_NUMBER("[ERROR] 다리 길이는 3 이상 20 이하인 숫자로 입력 가능합니다."),
    MOVING_WRONG_INPUT("[ERROR] U 또는 D 만 입력 가능합니다. ( U : 윗칸 선택 , D : 아랫칸 선택)"),
    RESTART_WRONG_INPUT("[ERROR] R 또는 Q만 입력 가능합니다. ( R : 재시작, Q : 게임 종료)");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
