package bridge.validator.domain;

import bridge.exception.LengthOutOfRangeException;
import java.util.List;

public class BridgeValidator {
  private static final int MIN_LENGTH = 3;
  private static final int MAX_LENGTH = 20;

  public static void validateLength(final int length) {
    if (!isLengthInRange(length)) {
      throw new LengthOutOfRangeException();
    }
  }

  public static void validateBridgeShape(final List<String> bridge) {
    for (String dir : bridge) {
      DirectionValidator.validate(dir);
    }
  }

  private static boolean isLengthInRange(final int length) {
    return length >= MIN_LENGTH && length <= MAX_LENGTH;
  }
}
