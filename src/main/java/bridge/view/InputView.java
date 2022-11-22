package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.message.InputMessage.PLEASE_ENTER_BRIDGE_SIZE;
import static bridge.message.InputMessage.PLEASE_ENTER_MOVE_COMMAND;
import static bridge.message.InputMessage.PLEASE_ENTER_GAME_COMMAND;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(PLEASE_ENTER_BRIDGE_SIZE);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoveCommand() {
        System.out.println(PLEASE_ENTER_MOVE_COMMAND);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(PLEASE_ENTER_GAME_COMMAND);
        return Console.readLine();
    }
}
