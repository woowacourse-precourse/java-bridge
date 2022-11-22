package bridge.view;

import bridge.message.Message;
import bridge.validate.InputValidate;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    InputValidate inputValidate = new InputValidate();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_LENGTH);
        String length = Console.readLine();
        inputValidate.validateInputEmpty(length);
        inputValidate.validateCharacter(length);
        inputValidate.validateInputRange(length);
        System.out.println();
        return Integer.parseInt(length);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.CHOOSE_MOVE_DIRECTION);
        String direction = Console.readLine();
        inputValidate.validateMoving(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.CHOOSE_RETRY);
        String retry = Console.readLine();
        inputValidate.validateRetry(retry);
        return retry;
    }
}
