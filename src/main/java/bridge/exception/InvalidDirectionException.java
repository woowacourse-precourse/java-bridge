package bridge.exception;

public class InvalidDirectionException extends IllegalArgumentException {
  private static final String INVALID_DIRECTION_EXCEPTION_MESSAGE = "잘못된 방향입니다.";

  public InvalidDirectionException() {
    super(INVALID_DIRECTION_EXCEPTION_MESSAGE);
  }
}
