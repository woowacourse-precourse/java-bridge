package bridge.exception;

public class LengthOutOfRangeException extends IllegalArgumentException {
  private static final String LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

  public LengthOutOfRangeException() {
    super(LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE);
  }
}
