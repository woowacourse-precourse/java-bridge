package bridge;

public final class ErrorMessage {

    public static final String INVALID_BRIDGE_SIZE_ERROR = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_MOVE_DIRECTION_ERROR = "이동할 칸은 위(U)나 아래(D) 중 하나여야만 합니다.";
    public static final String INVALID_GAME_COMMAND_ERROR = "입력은 게임 재시도(R)나 게임 종료(Q) 중 하나여야만 합니다.";

    private ErrorMessage() {
    }
}
