package bridge.view;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.REQUEST_BRIDGE_SIZE.getMessage());
        String size = Console.readLine().trim();
        return Validator.validateBridgeSize(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.REQUEST_MOVEMENT.getMessage());
        String moving = Console.readLine().trim();
        return Validator.validateMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.REQUEST_GAME_COMMAND.getMessage());
        String gameCommand = Console.readLine().trim();
        return Validator.validateGameCommand(gameCommand);
    }
}
