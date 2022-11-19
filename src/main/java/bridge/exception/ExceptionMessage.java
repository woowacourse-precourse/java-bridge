package bridge.exception;

public enum ExceptionMessage {
    INPUT_SHOULD_BE_U_OR_D("U 또는 D를 입력해야합니다."),
    NOT_VALID_BRIDGE_SIZE_INPUT("0과 이상이거나 다리 사이즈 미만이어야합니다."),
    NOT_VALID_RANDOM_NUMBER_GENERATED("0 또는 1 이외의 값이 생성되었습니다."),
    NULL_INPUT("null이 입력됐습니다."),
    CANNOT_MOVE_FURTHER("현재 index가 다리 길이를 초과했습니다."),
    INVALID_BRIDGE_SIZE("입력된 Bridge가 null이거나 size가 0입니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
