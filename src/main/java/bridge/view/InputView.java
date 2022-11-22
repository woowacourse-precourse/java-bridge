package bridge.view;

import bridge.exception.Exception;
import bridge.constant.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.INPUT_LENGTH.getMessage());
        String input = Console.readLine();
        try {
            return Exception.validateBridgeSize(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.CHOOSE_STEP.getMessage());
        String Moving = Console.readLine();
        try {
            return Exception.validateMoving(Moving);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.RESTART_MOVING.getMessage());
        String restartInput = Console.readLine();
        try {
            return Exception.validateGameCommand(restartInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
    }
}
