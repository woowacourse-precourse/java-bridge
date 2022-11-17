package bridge.exception;

public class NotFoundBridgeStateException extends IllegalArgumentException {
    public NotFoundBridgeStateException() {
        super("건널 수 있는 칸을 찾을 수 없습니다.\n");
    }
}
