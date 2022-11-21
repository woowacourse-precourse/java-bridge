package bridge.exception;

public class BridgeGameExceptionHandler {
    public static void handleMoveSpaceOutOfRangeException(int space) {
        if (!(3 <= space && space <= 20)) {
            throw new IllegalStateException("[ERROR] 이동 가능 범위(3~20)를 초과하였습니다.");
        }
    }
}
