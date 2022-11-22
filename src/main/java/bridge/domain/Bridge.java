package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

  private final List<BridgeArea> bridgeAreas;

  public Bridge(List<BridgeArea> areas) {
    this.bridgeAreas = areas;
  }

  public boolean canMove(int location, BridgeArea area) {
    if (bridgeAreas.size() >= location && bridgeAreas.get(location).equals(area)) {
      return true;
    }
    return false;
  }

  public List<BridgeArea> getBridgeAreas() {
    return bridgeAreas;
  }
}
