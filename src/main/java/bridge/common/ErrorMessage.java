package bridge.common;

public enum ErrorMessage {
    ILLEGAL_READ_GAME_COMMAND("R(재시작)과 Q(종료) 중 하나의 문자를 입력 해주세요."),
    ILLEGAL_READ_MOVING("U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력 해주세요."),
    ILLEGAL_READ_BRIDGE_SIZE("3 이상 20 이하의 숫자를 입력해주세요."),
    NOT_FOUND_BRIDGE("원하시는 브릿지가 없습니다.");


    private static final String TAG = "[ERROR]";
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getTagMessage() {
        return TAG + " " + message;
    }
}
