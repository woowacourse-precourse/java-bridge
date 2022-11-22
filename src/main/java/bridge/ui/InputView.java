package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

  /**
   * 다리의 길이를 입력받는다.
   */
  public int readBridgeSize() {
    try {
      System.out.println("다리의 길이를 입력해주세요.");
      String input = Console.readLine();
      InputChecker.checkIsNumber(input);
      int size = Integer.parseInt(input);
      InputChecker.checkIsInRange(size);
      return size;
    } catch (IllegalArgumentException e) {
      OutputView.printError(e);
      return readBridgeSize();
    }
  }

  /**
   * 사용자가 이동할 칸을 입력받는다.
   */
  public String readMoving() {
    try {
      System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
      String cmd = Console.readLine();
      InputChecker.checkMoveCMD(cmd);
      return cmd;
    } catch (IllegalArgumentException e) {
      OutputView.printError(e);
      return readMoving();
    }
  }

  /**
   * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
   */
  public String readGameCommand() {
    try {
      System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
      String cmd = Console.readLine();
      InputChecker.checkGameCMD(cmd);
      return cmd;
    } catch (IllegalArgumentException e) {
      OutputView.printError(e);
      return readGameCommand();
    }
  }
}
