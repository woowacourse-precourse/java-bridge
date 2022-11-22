package bridge.enums;

public enum ExceptionType {
    BRIDGE_SIZE_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INPUT_IN_SERVING_SHORTCUT("가능한 입력은 다음과 같습니다.");

    private String LEVEL = "[ERROR]";
    private String description;
    ExceptionType(String description) {
        this.description = description;
    }

    public String getMessage() {
        return LEVEL + " " + description;
    }
    public String getMessage(String guide) {
        return LEVEL + " " + description + guide;
    }
}
