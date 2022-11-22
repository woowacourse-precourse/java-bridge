package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.stream.Collectors;

public class GameController {

  private final BridgeMaker bridgeMaker;
  private final InputView inputView;
  private final OutputView outputView;

  public GameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
    this.bridgeMaker = bridgeMaker;
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public int getBridgeSize() {
    return inputView.readBridgeSize();
  }

  public Bridge makeBridge(int size) {
    return new Bridge(bridgeMaker.makeBridge(size)
            .stream().map(Direction::findByValue)
            .collect(Collectors.toList()));
  }

}