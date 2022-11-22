package bridge.view;

import bridge.exception.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeLength = Console.readLine();
        try {
            InputValidator.validateBridgeLength(bridgeLength);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        try {
            InputValidator.validateCorrectMovingCommand(moving);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String retryCommand = Console.readLine();
        try {
            InputValidator.validateCorrectRetryCommand(retryCommand);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readGameCommand();
        }
        return retryCommand;
    }
}
