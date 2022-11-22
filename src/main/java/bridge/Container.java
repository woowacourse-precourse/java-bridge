package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Container {

  public static GameController gameController () {
    return new GameController(bridgeMaker(), inputView(), outputView(), bridgeGame());
  }

  public static BridgeNumberGenerator bridgeNumberGenerator() {
    return new BridgeRandomNumberGenerator();
  }

  public static BridgeMaker bridgeMaker() {
    return new BridgeMaker(bridgeNumberGenerator());
  }

  public static InputView inputView() {
    return new InputView();
  }

  public static OutputView outputView() {
    return new OutputView();
  }

  public static BridgeGame bridgeGame() {
    return new BridgeGame();
  }

}
