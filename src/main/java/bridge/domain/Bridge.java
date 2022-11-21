package bridge.domain;

import java.util.List;

public class Bridge {
  private List<String> bridgeShapes;

  public Bridge(List<String> bridgeShapes) {
    this.bridgeShapes = bridgeShapes;
  }

  public List<String>getBridgeShapes() {
      return this.bridgeShapes;
  }
}
