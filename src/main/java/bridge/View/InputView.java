package bridge.View;

import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readBridgeSize() {
        System.out.println(Message.START_GAME_MESSAGE.getMessage());
        System.out.println(Message.INPUT_BRIDGE_SIZE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String readMoving() {
        System.out.println(Message.INPUT_MOVE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String readGameCommand() {
        System.out.println(Message.INPUT_GAME_COMMAND_MESSAGE.getMessage());
        return Console.readLine();
    }
}
