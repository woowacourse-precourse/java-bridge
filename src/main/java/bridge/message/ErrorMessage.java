package bridge.message;

public enum ErrorMessage {
    BRIDGE_SIZE_NOT_IN_RANGE("다리의 길이가 3이상 20이하가 아닙니다."),
    DIRECTION_NOT_U_D("입력 방향이 U나 D가 아닙니다."),
    RETRY_NOT_U_D("재시작 여부가 R이나 Q가 아닙니다."),
    INPUT_ONLY_ONE("입력값이 두 글자 이상입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
