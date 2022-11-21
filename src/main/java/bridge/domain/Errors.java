package bridge.domain;

public enum Errors {
    BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    FAIL_INPUT("[ERRORS] 올바른 값을 입력해주세요");

    String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
