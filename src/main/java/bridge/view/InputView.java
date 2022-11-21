package bridge.view;

import bridge.domain.User;
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
        //예외처리
        User.setBridgeSize(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        OutputView.printSelectMessage();
        String userInput = Console.readLine();
        //예외처리
        User.recordUserMoving(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        OutputView.printRestartMessage();
        String userInput = Console.readLine();
        //예외처리
        return userInput;
    }
}
