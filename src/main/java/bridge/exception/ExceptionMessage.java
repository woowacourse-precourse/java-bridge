package bridge.exception;

public enum ExceptionMessage {
    INPUT_SHOULD_BE_U_OR_D("U 또는 D를 입력해야합니다."),
    NOT_VALID_BRIDGE_SIZE("0과 이상이거나 다리 사이즈 미만이어야합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
