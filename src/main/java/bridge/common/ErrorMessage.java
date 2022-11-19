package bridge.common;

public enum ErrorMessage {
    ILLEGAL_READ_GAME_COMMAND("R(재시작)과 Q(종료) 중 하나의 문자를 입력 해주세요."),
    ILLEGAL_READ_MOVING("U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력 해주세요.");

    private static final String TAG = "[ERROR]";
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getTagMessage() {
        return TAG + " " + message;
    }
}
