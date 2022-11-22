package bridge.view;

import bridge.domain.User;
import bridge.utils.UserInputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static void readBridgeSize() {
        OutputView.printInputSize();
        String userInput = Console.readLine();
        try {
            UserInputException.checkUserInputBridgeSize(userInput);
            User.setBridgeSize(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printReadBridgeSizeError(e);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static void readMoving() {
        OutputView.printSelectMessage();
        String userInput = Console.readLine();
        try {
            UserInputException.isCorrectMovingCommand(userInput);
            User.recordUserMoving(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printReadMovingError(e);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printRestartMessage();
        String userInput = Console.readLine();
        try {
            UserInputException.isCorrectGameCommand(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            return OutputView.printReadGameCommandError(e);
        }
    }
}
