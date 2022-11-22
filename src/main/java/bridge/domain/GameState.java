package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameState {

  private int tryCount;
  private List<BridgeArea> movementHistory;
  private List<Boolean> stateHistory;

  public GameState() {
    this.tryCount = 1;
    this.movementHistory = new ArrayList<>();
    this.stateHistory = new ArrayList<>();
  }

  public int getTryCount() {
    return tryCount;
  }
  public List<BridgeArea> getMovementHistory() {
    return movementHistory;
  }

  public List<Boolean> getStateHistory() {
    return stateHistory;
  }

  public int getCurrentLocation() {
    return movementHistory.size();
  }

  public void addHistory(BridgeArea area, boolean isSuccess) {
    movementHistory.add(area);
    stateHistory.add(isSuccess);
  }

  public void retry() {
    tryCount++;
    movementHistory = new ArrayList<>();
    stateHistory = new ArrayList<>();
  }
}
