package bridge.utils.console;


import static bridge.utils.GameCommand.getGameCommand;
import static bridge.utils.GameCommand.validateCommand;
import static bridge.utils.Move.getMove;
import static bridge.utils.Move.validateMove;

import bridge.utils.BridgeSize;
import bridge.utils.GameCommand;
import bridge.utils.Move;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return new BridgeSize(Console.readLine()).getSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        String move = Console.readLine();
        validateMove(move);
        return getMove(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        String command = Console.readLine();
        validateCommand(command);
        return getGameCommand(command);
    }
}
