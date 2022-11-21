package bridge.config;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException() {
        super(ErrorMessageConstant.GAME_STATUS_NOT_ALLOW_MOVE);
    }
}
