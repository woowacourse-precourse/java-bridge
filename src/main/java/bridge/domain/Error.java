package bridge.domain;

public enum Error {
    BRIDGE_SIZE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_INTEGER_ERROR("[ERROR] 문자가 아닌 숫자를 입력해주세요."),
    INPUT_MOVING_ERROR("[ERROR] 위로 가려면 U, 아래로 가려면 D를 입력해주세요."),
    INPUT_RETRY_COMMAND("[ERROR] 재시작은 R, 종료는 Q를 입력해주세요.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
