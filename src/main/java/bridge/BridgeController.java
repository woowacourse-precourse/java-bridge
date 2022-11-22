package bridge;

import bridge.io.InputView;
import bridge.io.OutputView;

public class BridgeController {
  private int bridgeSize;
  private int gameCount;
  private int index;
  private boolean crossed;
  private InputView inputView;
  private OutputView outputView;
  private BridgeGame game;

  public BridgeController() {
    inputView = new InputView();
    outputView = new OutputView();
    gameCount = 1;
    crossed = true;
  }

  public void makeBridgeByInput() {
    outputView.printStart();
    bridgeSize = inputView.readBridgeSize();
    game = new BridgeGame(new Bridge((bridgeSize)));
  }

  public void crossBridge() {
    for (index = 0; index < bridgeSize; index++) {
      String move = inputView.readMoving();
      outputView.printMap(game.getMap(index, move));
      if (game.move(move, index)) continue;
      if (!game.retry(inputView.readGameCommand())) {
        crossed = false;
        break;
      }
      modifyForRetry();
    }
  }

  private void modifyForRetry() {
    game.initMap();
    index = -1;
    gameCount++;
  }

}