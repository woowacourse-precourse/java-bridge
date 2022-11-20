package bridge.constant;

public enum Directive {

    INPUT_SIZE_OF_BRIDGE("\n다리의 길이를 입력해주세요."),
    INPUT_MOVE_COMMAND("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;

    Directive(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
