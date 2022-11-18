package bridge;
/**
 * 게임 진행을 위해 필요한 메시지를 저장하는 역할을 한다.
 */
public enum Message {
    Game_Start("다리 건너기 게임을 시작합니다.\n"),
    Bridge_Size_Input("다리의 길이를 입력해주세요.");
    private String message;
    Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
