package bridge.exception;

import static bridge.validator.domain.BridgeValidator.MAX_LENGTH;
import static bridge.validator.domain.BridgeValidator.MIN_LENGTH;

public class LengthOutOfRangeException extends IllegalArgumentException {
  private static final String LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE =
      String.format("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.", MIN_LENGTH, MAX_LENGTH);

  public LengthOutOfRangeException() {
    super(LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE);
  }
}
