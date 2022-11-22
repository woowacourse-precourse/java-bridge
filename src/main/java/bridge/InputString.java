package bridge;

public enum InputString {
    BRIDGE_SIZE_INPUT_MESSAGE("다리의 길이를 입력해주새요."),
    MOVE_INPUT_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RETRY_INPUT_MESSAGE("게임을 다시 시도할지 여부를 입력해주세여. (재시도: R, 종료: Q)"),
    USER_MOVE_UP("U"),
    USER_MOVE_DOWN("D"),
    USER_RETRY("R"),
    USER_OVER("Q");

    protected final String INPUT_MESSAGE;

    InputString(String s) {
        INPUT_MESSAGE = s;
    }

    public String InputMessage() {
        return INPUT_MESSAGE;
    }
}
