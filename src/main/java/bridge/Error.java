package bridge;

public enum Error {
    INCLUDE_CAHRACTER("숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE("다리 길이는 3 이상 20 이하여야 합니다."),
    UP_OR_DOWN("위 또는 아래 중 선택되어야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
