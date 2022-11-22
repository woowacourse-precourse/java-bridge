package domain.bridge;

import java.util.ArrayList;
import java.util.List;

import static constant.ApplicationMessage.DOWN;
import static constant.ApplicationMessage.UP;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

  private final BridgeNumberGenerator bridgeNumberGenerator;

  public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
    this.bridgeNumberGenerator = bridgeNumberGenerator;
  }

  /**
   * @param size 다리의 길이
   * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
   */
  public List<String> makeBridge(int size) {
    List<String> bridge = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      addBridgeValue(bridge);
    }
    return bridge;
  }

  private void addBridgeValue(List<String> bridge) {
    int value = bridgeNumberGenerator.generate();
    if (value == 0) {
      bridge.add(DOWN);
    }
    if (value == 1) {
      bridge.add(UP);
    }
  }
}
