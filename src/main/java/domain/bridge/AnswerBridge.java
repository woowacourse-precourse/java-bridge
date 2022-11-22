package domain.bridge;

import domain.bridge.Bridge;
import domain.bridge.view.InputView;

import java.util.List;

public class AnswerBridge implements Bridge {
  private List<String> bridge;

  @Override
  public void setBridge() {

    makeAnswerBridge();
  }

  private void makeAnswerBridge() {
    InputView inputView = new InputView();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
  }

  @Override
  public boolean IsCorrect() {
    return false;
  }
}
