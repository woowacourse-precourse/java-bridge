package bridge.view;

public enum InputErrorCode {
    INVALID_BRIDGE_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING_COMMAND("올바른 알파벳을 입력해주세요. (위: U, 아래: D)");

    private final String ERROR_DESCRIPTION;

    InputErrorCode(String errorDescription) {
        this.ERROR_DESCRIPTION = errorDescription;
    }

    @Override
    public String toString() {
        return "[ERROR] " + ERROR_DESCRIPTION;
    }
}
