package bridge.view;

public enum GameMessage {
    ASK_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

    private final String message;
    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
