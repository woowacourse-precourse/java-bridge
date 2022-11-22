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

  public int getTryCount() {
    return tryCount;
  }
  public List<BridgeArea> getMovementHistory() {
    return movementHistory;
  }

  public int getCurrentLocation() {
    return movementHistory.size();
  }

  public void addHistory(BridgeArea area) {
    movementHistory.add(area);
  }

  public void retry() {
    tryCount++;
    movementHistory = new ArrayList<>();
  }
}
