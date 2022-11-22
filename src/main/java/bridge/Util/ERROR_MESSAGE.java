package bridge.Util;

public enum ERROR_MESSAGE {
    BRIDGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVE_ERROR("[ERROR] 입력값 형식에 올바르지 않습니다.");

    private String message;

    ERROR_MESSAGE(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
