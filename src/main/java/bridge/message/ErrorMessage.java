package bridge.message;

public enum ErrorMessage {
    BRIDGE_SIZE_RANGE_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_SIZE_TYPE_ERROR("[ERROR] 다리 길이는 정수만 가능합니다."),
    MOVE_COMMAND_FORMAT_ERROR("[ERROR] 이동은 U(위), D(아래) 만 가능합니다."),
    GAME_END_COMMAND_FORMAT_ERROR("[ERROR] R(재시작) 또는 Q(종료)만 입력하셔야합니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
