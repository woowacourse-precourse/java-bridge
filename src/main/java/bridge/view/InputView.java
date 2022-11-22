package bridge.view;

import bridge.exception.BridgeGameException;
import bridge.util.BridgeInputConverter;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeGameException bridgeGameException = new BridgeGameException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();
        bridgeGameException.validateBridgeSize(bridgeSize);
        return BridgeInputConverter.bridgeSizeConverter(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        bridgeGameException.validateDirection(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        bridgeGameException.validateGameStatusCommand(command);
        return command;
    }
}
