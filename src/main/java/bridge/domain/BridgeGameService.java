package bridge.domain;

import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.CreateBridgeGameCommand;
import bridge.domain.dto.MovingResult;

public class BridgeGameService {

  public BridgeGame createGame(CreateBridgeGameCommand command) {
    Bridge bridge = new Bridge(command.getBridges());
    GameState gameState = new GameState();
    return new BridgeGame(bridge, gameState);
  }

  public MovingResult moving(BridgeMoveCommand command) {
    BridgeGame bridgeGame = command.getBridgeGame();
    boolean moveResult = bridgeGame.move(command.getNextArea());
    return MovingResult.from(bridgeGame, moveResult);
  }

  public void retry(BridgeGame game){
    game.retry();
  }
}
