package bridge.constant;

public enum Directive {

    INPUT_SIZE_OF_BRIDGE("\n다리의 길이를 입력해주세요."),
    INPUT_MOVE_COMMAND("\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_RETRY("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    Directive(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
