package bridge;
/**
 * 출력할 메시지를 저장하는 역할을 한다.
 */
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
