package bridge.constant.message;

public enum InputMessage {

    ENTER_LENGTH_OF_BRIDGE("다리의 길이를 입력해주세요."),
    SELECT_WHERE_TO_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
