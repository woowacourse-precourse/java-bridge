package bridge.domain.dto;

import bridge.domain.BridgeGame;

public class MovingResult {

  private boolean isClear;

  private boolean isMoveSuccess;
  private BridgeGame bridgeGame;

  public MovingResult(boolean isClear, boolean isMoveSuccess, BridgeGame bridgeGame) {
    this.isClear = isClear;
    this.isMoveSuccess = isMoveSuccess;
    this.bridgeGame = bridgeGame;
  }

  public static MovingResult from(BridgeGame game, boolean moveResult) {
    return new MovingResult(game.isClear(), moveResult, game);
  }

  public boolean isClear() {
    return isClear;
  }

  public boolean isMoveSuccess() {
    return isMoveSuccess;
  }

  public BridgeGame getBridgeGame() {
    return bridgeGame;
  }
}
