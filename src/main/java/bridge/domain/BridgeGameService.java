package bridge.domain;

import bridge.BridgeMaker;
import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.ReTryCommand;
import bridge.domain.command.SetBridgeSizeCommand;
import java.util.List;

public class BridgeGameService {

  private final Input input;
  private final BridgeMaker bridgeMaker;
  private final Output output;

  public BridgeGameService(Input input, BridgeMaker bridgeMaker, Output output) {
    this.input = input;
    this.bridgeMaker = bridgeMaker;
    this.output = output;
  }

  public void start() {
    BridgeGame game = init();
    boolean result = progress(game);
    output.printResult(game.getGameState(), result);
  }

  private BridgeGame init() {
    SetBridgeSizeCommand command = input.readBridgeSize();
    List<String> bridgeAreas = bridgeMaker.makeBridge(command.getSize());
    return BridgeGame.createGame(bridgeAreas);
  }

  private boolean progress(BridgeGame game) {
    if (game.isClear()) {
      return true;
    }
    if (progressMove(game)) {
      return progress(game);
    }
    ReTryCommand tryCommand = input.readGameCommand();
    if (tryCommand.isReTry()) {
      game.retry();
      return progress(game);
    }
    return false;
  }

  private boolean progressMove(BridgeGame game) {
    BridgeMoveCommand bridgeMoveCommand = input.readMoving();
    boolean move = game.move(bridgeMoveCommand.getArea());
    output.printMap(game.getGameState());
    return move;
  }
}
