package bridge.domain.command;

import bridge.domain.BridgeArea;
import bridge.domain.BridgeGame;

public class BridgeMoveCommand {

  private BridgeArea nextArea;
  private BridgeGame bridgeGame;

  public BridgeMoveCommand(String input, BridgeGame game) {
    BridgeArea nextArea = BridgeArea.of(input);
    this.nextArea = nextArea;
    this.bridgeGame = game;
  }

  public BridgeArea getNextArea() {
    return nextArea;
  }

  public BridgeGame getBridgeGame() {
    return bridgeGame;
  }
}
