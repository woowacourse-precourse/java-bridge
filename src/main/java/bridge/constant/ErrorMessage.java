package bridge.constant;

public enum ErrorMessage {
    // TODO: enum 적용
    NUMBER("[[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다"),
    UP_And_Down("[ERROR] 이동할 칸이 위면 U, 아래면 D여야 합니다."),
    RESTART("[ERROR] R, Q만 입력해주세요.");

    private final String error;

    ErrorMessage(final String error) {
        this.error = error;
    }

    public String printError() {
        return error;
    }
}
