package bridge.infra;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameService;
import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.CreateBridgeGameCommand;
import bridge.infra.dto.ReTryCommand;
import bridge.domain.dto.MovingResult;
import bridge.infra.dto.InputBridgeSize;
import java.util.List;

public class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final BridgeMaker bridgeMaker;
  private final BridgeGameService bridgeGameService;

  public GameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker,
      BridgeGameService bridgeGameService) {
    this.inputView = inputView;
    this.outputView = outputView;
    this.bridgeMaker = bridgeMaker;
    this.bridgeGameService = bridgeGameService;
  }


  private BridgeGame initGame() {
    CreateBridgeGameCommand bridgeCommand = getCreateGameCommand();
    return bridgeGameService.createGame(bridgeCommand);
  }

  private MovingResult moving(BridgeGame game) {
    BridgeMoveCommand moveCommand = getMoveCommand(game);
    MovingResult result = bridgeGameService.moving(moveCommand);
    outputView.printMap(result.getBridgeGame().getGameState());
    return result;
  }

  public void run() {
    BridgeGame bridgeGame = initGame();
    MovingResult result = moving(bridgeGame);
    while (!result.isClear()) {
      if (isGameEnd(result)) {
        break;
      }
      result = moving(bridgeGame);
    }
    outputView.printResult(result.getBridgeGame().getGameState(), result.isClear());
  }

  private boolean isGameEnd(MovingResult result) {
    if (result.isMoveSuccess()) {
      return false;
    }
    if (isRetry()) {
      bridgeGameService.retry(result.getBridgeGame());
      return false;
    }
    return true;
  }

  private boolean isRetry() {
    ReTryCommand reTryCommand = getReTryCommand();
    return reTryCommand.isReTry();
  }

  private CreateBridgeGameCommand getCreateGameCommand() {
    try {
      InputBridgeSize inputBridgeSize = inputView.readBridgeSize();
      List<String> bridges = bridgeMaker.makeBridge(inputBridgeSize.getSize());
      return new CreateBridgeGameCommand(bridges);
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] " + e.getMessage());
      return getCreateGameCommand();
    }
  }

  private BridgeMoveCommand getMoveCommand(BridgeGame game) {
    try {
      return new BridgeMoveCommand(inputView.readMoving(), game);
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] " + e.getMessage());
      return getMoveCommand(game);
    }
  }

  private ReTryCommand getReTryCommand() {
    try {
      return new ReTryCommand(inputView.readGameCommand());
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] " + e.getMessage());
      return getReTryCommand();
    }
  }
}
