package bridge.domain;

import bridge.validator.domain.BridgeValidator;

import java.util.List;

public class Bridge {
  private final List<String> bridgeShapes;

  public Bridge(List<String> bridgeShapes) {
    BridgeValidator.validateBridgeShape(bridgeShapes);
    BridgeValidator.validateLength(bridgeShapes.size());
    this.bridgeShapes = bridgeShapes;
  }

  public List<String> getBridgeShapes() {
    return this.bridgeShapes;
  }

  public boolean isArriveFinishLine(int moveCount) {
    return bridgeShapes.size() == moveCount;
  }
}
