package bridge;

import java.util.List;

public class BridgeShapeValidator {
  public static void validate(final List<String> bridge) {
    validateBridgeShape(bridge);
  }

  private static void validateBridgeShape(final List<String> bridge) {
    for (String shape : bridge) {
      if (!isUpOrDown(shape)) {
        throw new IllegalArgumentException("[ERROR] 다리의 모양이 잘못되었습니다.");
      }
    }
  }

  private static boolean isUpOrDown(String shape) {
    return shape.equals(BridgeMaker.UP) || shape.equals(BridgeMaker.DOWN);
  }
}
