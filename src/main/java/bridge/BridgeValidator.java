package bridge;

import bridge.exception.InvalidBridgeShapeException;
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
    for (String shape : bridge) {
      if (!isUpOrDown(shape)) {
        throw new InvalidBridgeShapeException();
      }
    }
  }

  private static boolean isLengthInRange(final int length) {
    return length >= MIN_LENGTH && length <= MAX_LENGTH;
  }

  private static boolean isUpOrDown(String shape) {
    return shape.equals(BridgeMaker.UP) || shape.equals(BridgeMaker.DOWN);
  }
}
