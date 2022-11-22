package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.validator.domain.BridgeValidator;
import java.util.ArrayList;
import java.util.List;

/** 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다. */
public class BridgeMaker {
  private final BridgeNumberGenerator bridgeNumberGenerator;

  public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
    this.bridgeNumberGenerator = bridgeNumberGenerator;
  }

  /**
   * @param length 다리의 길이
   * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
   */
  public List<String> makeBridge(int length) {
    BridgeValidator.validateLength(length);
    List<String> bridgeShape = getBridgeShape(length);
    BridgeValidator.validateBridgeShape(bridgeShape);
    return bridgeShape;
  }

  private String getUpOrDown() {
    if (trueOrFalseByRandom()) {
      return Direction.UP.getDirection();
    }
    return Direction.DOWN.getDirection();
  }

  private List<String> getBridgeShape(int length) {
    List<String> bridgeShape = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      bridgeShape.add(getUpOrDown());
    }
    return bridgeShape;
  }

  private boolean trueOrFalseByRandom() {
    return bridgeNumberGenerator.generate() == 1;
  }
}
