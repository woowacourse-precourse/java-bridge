package bridge.message;

public enum ErrorMessage {
    BRIDGE_SIZE_OUT_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_UD("U 또는 D를 입력해야 합니다."),
    INPUT_RQ("R 또는 Q를 입력해야 합니다."),
    INPUT_INTEGER("정수를 입력해야 합니다."),
    INPUT_ERROR("입력 과정에서 오류가 발생했습니다."),
    INPUT_ONE_CHARACTER("알파벳 하나를 입력해야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
