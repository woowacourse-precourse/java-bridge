package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

  private final List<BridgeArea> bridgeAreas;

  public Bridge(List<String> areas) {
    this.bridgeAreas = areas.stream().map(BridgeArea::of).collect(Collectors.toList());
  }

  public boolean canMove(int location, BridgeArea area) {
    if (bridgeAreas.size() >= location && bridgeAreas.get(location - 1).equals(area)) {
      return true;
    }
    return false;
  }

}
