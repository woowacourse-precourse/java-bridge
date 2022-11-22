package bridge.infra;

import bridge.constant.Message;
import bridge.infra.dto.InputBridgeSize;
import camp.nextstep.edu.missionutils.Console;

public class InputView {


  public InputBridgeSize readBridgeSize() {
    printGuideMessage(Message.REQUEST_INPUT_BRIDGE_SIZE);
    return new InputBridgeSize(getInput());
  }


  public String readMoving() {
    printGuideMessage(Message.REQUEST_INPUT_BRIDGE_MOVE);
    return getInput();
  }


  public String readGameCommand() {
    printGuideMessage(Message.REQUEST_INPUT_RETRY_SIGNAL);
    return getInput();
  }


  private void printGuideMessage(Message guideMessage) {
    System.out.println(guideMessage.getText());
  }

  private String getInput() {
    return Console.readLine();
  }

}
