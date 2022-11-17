package bridge.exception;

public class NotFoundBridgeException extends IllegalArgumentException {
    public NotFoundBridgeException() {
        super("다리를 찾을 수 없습니다.\n");
    }
}
