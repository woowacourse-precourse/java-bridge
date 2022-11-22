package bridge;

import static bridge.constants.InputConstants.*;
import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        System.out.println(START_GAME.getMessage());
        System.out.println();
        System.out.println(INPUT_BRIDGE_SIZE.getMessage());
        return readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(CHOOSE_MOVE_COMMAND.getMessage());
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(CHOOSE_RETRY_COMMAND.getMessage());
        return readLine();
    }
}
