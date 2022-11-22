package bridge.output;

public enum Error {

    BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING("[ERROR] 이동할 칸은 U나 D로 입력하여야 합니다."),
    GAME_COMMAND("[ERROR] 게임 재시작/종료 여부는 R이나 Q로 입력하여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
