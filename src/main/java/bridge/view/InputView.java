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
        OutputView.printGameStart();
        OutputView.printInputSize();
        String userInput = Console.readLine();
        try {
            UserInputException.checkUserInputBridgeSize(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
        User.setBridgeSize(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static void readMoving() {
        OutputView.printSelectMessage();
        String userInput = Console.readLine();
        try {
            UserInputException.isCorrectMovingCommand(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
        User.recordUserMoving(userInput);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        OutputView.printRestartMessage();
        String userInput = Console.readLine();
        try {
            UserInputException.isCorrectGameCommand(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
        return userInput;
    }
}
