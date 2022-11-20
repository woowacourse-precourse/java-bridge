package bridge.utils.message;

public enum GameMessagesUtil {
    START("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    CHOICE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    SHOW_BRIDGE("[ %s ]\n[ %s ]\n");

    final String message;

    GameMessagesUtil(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
