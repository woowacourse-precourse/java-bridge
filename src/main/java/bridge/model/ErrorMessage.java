package bridge.model;

public enum ErrorMessage {
    ERROR_MESSAGE_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_MESSAGE_MOVING("[ERROR] 이동할 칸은 U 또는 D가 입력되어야 합니다."),
    ERROR_MESSAGE_GAME_COMMAND("[ERROR] 게임 재시도 여부는 R 또는 Q 가 입력되어야 합니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
