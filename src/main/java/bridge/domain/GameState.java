package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameState {

  private int tryCount;
  private List<BridgeArea> movementHistory;

  public GameState() {
    this.tryCount = 1;
    this.movementHistory = new ArrayList<>();
  }

}
