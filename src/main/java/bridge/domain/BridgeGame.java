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

  public void move() {
  }


  public void retry() {
  }
}
