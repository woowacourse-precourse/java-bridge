package bridge.view;

import bridge.type.GameOptionType;
import camp.nextstep.edu.missionutils.Console;
import utils.IOMessage;
import utils.IllegalInputChecker;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    IllegalInputChecker illegalInputChecker = new IllegalInputChecker();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(IOMessage.BRIDGE_SIZE_MSG);
        return illegalInputChecker.checkBridgeSizeInput(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(IOMessage.UP_OR_DOWN_MSG);
        return illegalInputChecker.checkMoveInput(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameOptionType readGameCommand() {
        System.out.println(IOMessage.RESTART_MSG);
        return illegalInputChecker.checkRestartOrQuit(Console.readLine());
    }
}
