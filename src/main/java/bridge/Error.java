package bridge;

public enum Error {
    NOT_NUMBER("[ERROR] 숫자만 입력해주세요"),
    NOT_IN_RANGE("[ERROR] 3이상 20이하 정수로 입력해주세요"),
    NOT_MOVE_INPUT("[ERROR] 이동하려면 U 또는 D만 입력해주세요"),
    NOT_RETRY_INPUT("[ERROR] 재시도하려면 R 또는 Q만 입력해주세요"),
    ;

    private final String label;

    Error(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
