package bridge.exception;

public enum IllegalArgumentExceptionMessage {
    ILLEGAL_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ILLEGAL_BRIDGE_POSITION("[ERROR] 이동할 칸은 대문자 'U' 또는 대문자 'D'의 문자여야합니다."),
    ILLEGAL_GAME_COMMAND("[ERROR] 게임 재시작 여부는 대문자 'R' 또는 대문자 'Q'의 문자여야합니다."),
    ;

    final String message;


    IllegalArgumentExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
