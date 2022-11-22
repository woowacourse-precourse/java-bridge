package bridge.constant;

public enum ErrorMessage {
    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫지여야 합니다."),
    INPUT_BRIDGE_SIZE_ERROR("다리 길이는 양의 정수만 입력할 수 있습니다."),
    INPUT_DIRECTION_ERROR("이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있습니다."),
    INPUT_RETRY_OR_QUIT_ERROR("게임 재시도 여부는 R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다.");

    private static final String ERROR_FORMAT = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_FORMAT + message;
    }
}
