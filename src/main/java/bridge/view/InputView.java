package bridge.view;

import bridge.command.BridgeSizeCommand;
import bridge.command.ReadMovingCommand;
import bridge.command.RetryCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public final class InputView {
    private static final String OVER_RANGE_MESSAGE = "입력의 범위를 초과했습니다";

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeCommand readBridgeSize() {
        final String input = Console.readLine();
        try {
            return new BridgeSizeCommand(input);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
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
