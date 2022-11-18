package bridge;

public enum Message {
    Game_Start("다리 건너기 게임을 시작합니다.");
    private String message;
    Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
