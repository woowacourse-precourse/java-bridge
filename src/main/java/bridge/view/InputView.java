package bridge.view;

import bridge.utils.Message;
import bridge.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.INPUT_LENGTH);
        String size = Console.readLine();
        Validator.validateBridgeSize(size);
        return Integer.parseInt(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.SELECT_MOVE);
        String move = Console.readLine();
        Validator.validateMove(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.SELECT_RETRY);
        String command = Console.readLine();
        Validator.validateGameCommand(command);
        return command;
    }
}
