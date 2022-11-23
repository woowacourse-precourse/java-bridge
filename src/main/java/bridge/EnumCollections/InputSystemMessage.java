package bridge.EnumCollections;

public enum InputSystemMessage {
    BRIDGE_LENGTH_INPUT("다리의 길이를 입력해주세요."),
    MOVE_BRIDGE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_RESTART_INPUT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String message;

    InputSystemMessage(String message) {
        this.message = message;
    }

    public static String getMessage(InputSystemMessage situation) {
        return situation.message;
    }
}
