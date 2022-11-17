package bridge.view;

import bridge.option.GameCommand;
import bridge.option.Move;
import bridge.size.BridgeSize;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        String size = Console.readLine();
        return new BridgeSize(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving() {
        String move = Console.readLine();
        return new Move(move);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        String command = Console.readLine();
        return new GameCommand(command);
    }
}
