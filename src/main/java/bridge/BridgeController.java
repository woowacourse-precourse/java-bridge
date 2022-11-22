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


}