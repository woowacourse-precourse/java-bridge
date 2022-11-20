package bridge;

import java.util.List;

public class BridgeGameController {
  private InputView inputView;
  private OutputView outputView;

  public int inputViewSize() {
    return inputView.readBridgeSize();
  }

  public String inputViewMoving() {
    return inputView.readMoving();
  }

  public String inputViewCommand() {
    return inputView.readGameCommand();
  }

  public void outputViewResult(List<String> up, List<String > down) {
    outputView.printMap(up);
    outputView.printMap(down);
  }
}
