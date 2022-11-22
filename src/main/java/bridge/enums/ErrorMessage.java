package bridge.enums;

public enum ErrorMessage {
    IS_NOT_NUMBER("숫자가 아닌 값을 입력했습니다."),
    OUT_OF_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    OUT_OF_OPTIONS("주어진 선택지를 벗어났습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}