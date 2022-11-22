package bridge.model;

public enum ErrorMessage {
    BRIDGE_SIZE_IS_NOT_NUMERIC("다리의 길이는 숫자로 입력해야합니다."),
    OUT_OF_BRIDGE_SIZE_RANGE("다리의 길이는 %d부터 %d 사이의 숫자여야 합니다."),
    WRONG_MOVING_DIRECTION(String.format("이동할 칸은 %s 또는 %s로 입력해야 합니다.", UserKeySet.UP, UserKeySet.DOWN)),
    WRONG_GAME_COMMEND(String.format("게임 진행은 %s 또는 %s로 입력해야 합니다.", UserKeySet.RETRY, UserKeySet.QUIT));

    private static final String PREFIX = "[ERROR]";

    private final String msg;
    ErrorMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format("%s %s", PREFIX, msg);
    }
}
