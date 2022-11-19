package bridge.infra;

import bridge.constant.Message;
import bridge.domain.Input;
import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.SetBridgeSizeCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView implements Input {

  /**
   * 다리의 길이를 입력받는다.
   */
  @Override
  public SetBridgeSizeCommand readBridgeSize() {
    printGuideMessage(Message.REQUEST_INPUT_BRIDGE_SIZE);
    try {
      return new SetBridgeSizeCommand(getInput());
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] " + e.getMessage());
      return readBridgeSize();
    }
  }

  /**
   * 사용자가 이동할 칸을 입력받는다.
   */
  @Override
  public BridgeMoveCommand readMoving() {
    printGuideMessage(Message.REQUEST_INPUT_BRIDGE_MOVE);
    try {
      return new BridgeMoveCommand(getInput());
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR]" + e.getMessage());
      return readMoving();
    }
  }

  /**
   * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
   */
  public String readGameCommand() {
    return null;
  }


  private void printGuideMessage(Message guideMessage) {
    System.out.println(guideMessage.getText());
  }

  private String getInput() {
    return Console.readLine();
  }

}
