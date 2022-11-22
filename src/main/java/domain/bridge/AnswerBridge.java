package domain.bridge;

import view.InputView;
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

    System.out.println("다리의 길이를 입력해주세요.");
    try {
      bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }

  public boolean isCorrect(List<String> user_bridge) {
    int last_ub = user_bridge.size() - 1;

    return bridge.get(last_ub).equals(user_bridge.get(last_ub));
  }

  public int getBridgeSize() {
    return bridge.size();
  }
}
