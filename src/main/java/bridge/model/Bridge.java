package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;

import java.util.List;

public class Bridge {
  private List<String> bridge;

  public Bridge(int size) {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    bridge = bridgeMaker.makeBridge(size);
  }

  public boolean canCross(String inputKey, int index) {
    return bridge.get(index).equals(inputKey);
  }

  public int getBridgeSize() {
    return bridge.size();
  }

  public boolean isSame(int index, String direction) {
    return bridge.get(index).equals(direction);
  }
}
