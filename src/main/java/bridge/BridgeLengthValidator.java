package bridge;

import bridge.exception.LengthOutOfRangeException;

public class BridgeLengthValidator {
  private static final int MIN_LENGTH = 3;
  private static final int MAX_LENGTH = 20;

  public static void validate(final int length) {
    validateLengthInRange(length);
  }

  private static void validateLengthInRange(final int length) {
    if (!isLengthInRange(length)) {
      throw new LengthOutOfRangeException();
    }
  }

  private static boolean isLengthInRange(final int length) {
    return length >= MIN_LENGTH && length <= MAX_LENGTH;
  }
}
