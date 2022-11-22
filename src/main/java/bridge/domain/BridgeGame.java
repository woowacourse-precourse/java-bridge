package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

  private final Bridge bridge;
  private final GameState gameState;

  public BridgeGame(Bridge bridge, GameState gameState) {
    this.bridge = bridge;
    this.gameState = gameState;
  }

  public static BridgeGame createGame(List<String> areas) {
    return new BridgeGame(new Bridge(areas), new GameState());
  }

  public boolean move(BridgeArea nextArea) {
    int currentLocation = gameState.getCurrentLocation();
    if (bridge.canMove(currentLocation, nextArea)) {
      gameState.addHistory(nextArea, true);
      return true;
    }
    gameState.addHistory(nextArea, false);
    return false;
  }

  public boolean isClear() {
    List<BridgeArea> bridgeAreas = bridge.getBridgeAreas();
    List<BridgeArea> movementHistory = gameState.getMovementHistory();
    return equalAll(bridgeAreas, movementHistory);
  }

  private boolean equalAll(List<BridgeArea> bridge, List<BridgeArea> userHistory) {
    if (bridge.size() != userHistory.size()) {
      return false;
    }
    for (int i = 0; i < bridge.size(); i++) {
      if (!bridge.get(i).equals(userHistory.get(i))) {
        return false;
      }
    }
    return true;
  }

  public void retry() {
    gameState.retry();
  }
}
