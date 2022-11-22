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
    List<Boolean> stateHistory = gameState.getStateHistory();
    List<BridgeArea> bridgeAreas = bridge.getBridgeAreas();
    if(stateHistory.size() != bridgeAreas.size()){
      return false;
    }
    return isAllSuccess(stateHistory);
  }

  private boolean isAllSuccess(List<Boolean> stateHistory){
    for(boolean result : stateHistory){
      if(!result){
        return false;
      }
    }
    return true;
  }


  public void retry() {
    gameState.retry();
  }

  public GameState getGameState() {
    return gameState;
  }
}
