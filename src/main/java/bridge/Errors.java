package bridge;

public enum Errors {
    ONLY_NUMBER("[ERROR] 숫자만 입력해야합니다."),
    BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    FAIL_INPUT("[ERRORS] 올바른 값을 입력해주세요"),
    OPERATION_FAIL("[ERROS] 해당연산을 찾을 수가 없습니다");
    String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
