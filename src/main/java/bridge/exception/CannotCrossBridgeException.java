package bridge.exception;

public class CannotCrossBridgeException extends RuntimeException {

    public CannotCrossBridgeException() {
        super("[Error] 이동할 수 없는 칸입니다.");
    }
}
