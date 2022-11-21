package bridge.view;

import bridge.domain.BridgeGameRetryCommand;
import bridge.domain.BridgePosition;
import bridge.domain.BridgeSize;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MSG = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_AREA_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_GAME_RETRY_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MSG);
        return new BridgeSize(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgePosition readMoving() {
        System.out.println(INPUT_MOVING_AREA_MSG);
        return BridgePosition.getPositionWithCommand(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public BridgeGameRetryCommand readGameCommand() {
        System.out.println(INPUT_GAME_RETRY_MSG);
        return BridgeGameRetryCommand.getRetryCommandWithCommand(Console.readLine());
    }
}
