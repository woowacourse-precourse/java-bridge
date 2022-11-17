package bridge.view;

public enum GameMessage {
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    ASK_NEXT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)");

    private final String message;
    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
