package bridge;

public enum Error {

    NONE("[ERROR] IllegalStateException 발생! 값을 입력해야 합니다."),
    INTEGER("[ERROR] IllegalArgumentException 발생! 숫자로만 입력해야 합니다."),
    RANGE("[ERROR] IllegalArgumentException 발생! 다리의 길이는 3~20 사이여야 합니다."),
    CHARACTER("[ERROR] IllegalArgumentException 발생! 올바른 문자를 입력해야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
