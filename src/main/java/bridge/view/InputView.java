package bridge.view;

import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.exception.NotIntegerException;
import camp.nextstep.edu.missionutils.Console;

/** 사용자로부터 입력을 받는 역할을 한다. */
public class InputView {
  /** 다리의 길이를 입력받는다. */
  public static int readBridgeSize() {
    return stringToInt(Console.readLine());
  }

  /** 사용자가 이동할 칸을 입력받는다. */
  public static String readMoving() {
    String moveDirection = Console.readLine();
    Direction.validateDirection(moveDirection);
    return moveDirection;
  }

  /** 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. */
  public static String readGameCommand() {
    String gameCommand = Console.readLine();
    GameCommand.validateGameCommand(gameCommand);
    return gameCommand;
  }

  private static int stringToInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new NotIntegerException();
    }
  }
}
