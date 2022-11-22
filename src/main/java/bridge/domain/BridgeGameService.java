package bridge.domain;

import bridge.domain.command.CreateBridgeGameCommand;

public class BridgeGameService {

  public BridgeGame createGame(CreateBridgeGameCommand command) {
    Bridge bridge = new Bridge(command.getBridges());
    GameState gameState = new GameState();
    return new BridgeGame(bridge, gameState);
  }
}
