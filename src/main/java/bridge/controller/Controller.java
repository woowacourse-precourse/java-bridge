package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
  InputView inputView = new InputView();
  OutputView outputView = new OutputView();

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
