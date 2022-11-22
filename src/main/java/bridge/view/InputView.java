package bridge.view;

import bridge.command.BridgeSizeCommand;
import bridge.command.ReadMovingCommand;
import bridge.command.RetryCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public final class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeCommand readBridgeSize() {
        final String input = Console.readLine();
        return new BridgeSizeCommand(input);
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public ReadMovingCommand readMoving() {
        return new ReadMovingCommand(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RetryCommand readGameCommand() {
        return new RetryCommand(Console.readLine());
    }
}
