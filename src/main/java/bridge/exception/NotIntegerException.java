package bridge.exception;

public class NotIntegerException extends IllegalArgumentException {
  private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "정수가 아닙니다.";

  public NotIntegerException() {
    super(NOT_INTEGER_EXCEPTION_MESSAGE);
  }
}
