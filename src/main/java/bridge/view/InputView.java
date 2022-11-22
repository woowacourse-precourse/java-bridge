package bridge.view;

import bridge.domain.GameCommand;
import bridge.validator.domain.DirectionValidator;
import bridge.validator.view.NumberInputValidator;
import camp.nextstep.edu.missionutils.Console;

import static bridge.view.OutputView.*;

/** 사용자로부터 입력을 받는 역할을 한다. */
public class InputView {
  /** 다리의 길이를 입력받는다. */
  public static int readBridgeSize() {
    printLengthInputMessage();
    String input = Console.readLine();
    NumberInputValidator.validate(input);
    return Integer.parseInt(input);
  }

  /** 사용자가 이동할 칸을 입력받는다. */
  public static String readMoving() {
    printMoveDirInputMessage();
    String moveDirection = Console.readLine();
    DirectionValidator.validate(moveDirection);
    return moveDirection;
  }

  /** 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다. */
  public static String readGameCommand() {
    printCheckRetryInputMessage();
    String gameCommand = Console.readLine();
    GameCommand.validateGameCommand(gameCommand);
    return gameCommand;
  }
}
