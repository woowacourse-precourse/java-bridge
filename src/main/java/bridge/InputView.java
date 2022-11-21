package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.InputType.*;
import static bridge.WordType.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(READ_BRIDGE_SIZE.getMessage());
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(String.format(READ_MOVING.getMessage(), UP.getWord(), DOWN.getWord()));
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(String.format(READ_GAME_COMMAND.getMessage(), RESTART.getWord(), END.getWord()));
        return Console.readLine();
    }
}
