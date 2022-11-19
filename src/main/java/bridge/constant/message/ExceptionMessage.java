package bridge.constant.message;

public enum ExceptionMessage {
    ERROR("[ERROR] ")
    , BRIDGE_LENGTH_TYPE(ERROR.message + "다리의 길이는 숫자여야 합니다.")
    , BRIDGE_LENGTH_RANGE(ERROR.message + "다리의 길이는 3~20 사이여야 합니다.")
    , PLAYER_MOVE(ERROR.message + "%s(위) 혹은 %s(아래)만 입력할 수 있습니다.")
    , RESTART(ERROR.message + "%s(재시도) 혹은 %s(종료)만 입력할수 있습니다.")
    ;
    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
