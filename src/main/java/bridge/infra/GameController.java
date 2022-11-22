package bridge.infra;

import bridge.BridgeMaker;
import bridge.domain.BridgeGameService;
import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.CreateBridgeGameCommand;
import bridge.domain.command.ReTryCommand;
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


  public void initGame() {
    CreateBridgeGameCommand bridgeCommand = getCreateGameCommand();

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

  private BridgeMoveCommand getMoveCommand() {
    try {
      return new BridgeMoveCommand(inputView.readMoving());
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] " + e.getMessage());
      return getMoveCommand();
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
